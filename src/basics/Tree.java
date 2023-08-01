package basics;

public class Tree<T extends Number> {
    private int idx = -1;
    public TreeNode root = null;

    public static final String TRAVERSE_TYPE_INORDER = "inorder";
    public static final String TRAVERSE_TYPE_PREORDER = "preorder";
    public static final String TRAVERSE_TYPE_POSTORDER = "postorder";
    public static final String TRAVERSE_TYPE_LEVELORDER = "levelorder";

    public TreeNode getRoot(){
        return this.root;
    }

    public TreeNode getLeftChild(){
        return this.root.left;
    }

    public TreeNode getRightChild(){
        return this.root.right;
    }

    public class TreeNode {
        public T data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }
    }

    public TreeNode buildTree(Collections<T> list){
        idx = idx + 1;
        if(idx <= list.size()) {
            if(list.get(idx).doubleValue() == -1){
                return null; 
            }
            TreeNode newNode = new TreeNode(list.get(idx));
            if(this.root == null){
                this.root = newNode;
            }
            newNode.left = buildTree(list);
            newNode.right = buildTree(list);
            return newNode;
        } else {
            return null;
        }
    }

    /* Traversals */

    public void traverseTree(String type){
        if(type.equalsIgnoreCase(TRAVERSE_TYPE_INORDER)) {
            inorder(root);
        }
        if(type.equalsIgnoreCase(TRAVERSE_TYPE_PREORDER)) {
            preorder(root);
        }
        if(type.equalsIgnoreCase(TRAVERSE_TYPE_POSTORDER)) {
            postorder(root);
        }
        if(type.equalsIgnoreCase(TRAVERSE_TYPE_LEVELORDER)) {
            levelorder(root);
        }
    }

    public void inorder(TreeNode root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(TreeNode root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelorder(TreeNode root){
        Queue<TreeNode> q = new Queue<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.offer(null);
                }
            } else {
                System.out.print(currNode.data+ " ");
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
        }
    }


    
}
