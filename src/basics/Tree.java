package basics;

public class Tree<T extends Number> {
    private int idx = -1;
    public TreeNode root = null;

    public class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        public TreeNode(T data){
            this.data = data;
        }
    }

    public TreeNode buildTree(Collections<T> list){
        idx = idx + 1;
        if(idx <= list.size()) {
            if(list.get(idx) == null){
                return null; 
            }
            TreeNode newNode = new TreeNode(list.get(idx));
            newNode.left = buildTree(list);
            newNode.right = buildTree(list);
            if(idx == list.size() - 1){
                this.root = newNode;
            }
            return newNode;
        } else {
            return null;
        }
    }

    public TreeNode getRoot(){
        return this.root;
    }

    public TreeNode getLeftChild(){
        return this.root.left;
    }

    public TreeNode getRightChild(){
        return this.root.right;
    }
    
}
