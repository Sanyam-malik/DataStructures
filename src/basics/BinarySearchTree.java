package basics;

public class BinarySearchTree<T extends Number> {
    
    TreeNode root = null;
    int idx = -1;

    public static final String TRAVERSE_TYPE_INORDER = "inorder";
    public static final String TRAVERSE_TYPE_PREORDER = "preorder";
    public static final String TRAVERSE_TYPE_POSTORDER = "postorder";
    public static final String TRAVERSE_TYPE_LEVELORDER = "levelorder";

    public class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        public TreeNode(T data){
            this.data = data;
        }

        public T getData(){
            return data;
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

    public TreeNode insert(TreeNode root, T val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(root.data.doubleValue() > val.doubleValue()){
            root.left = insert(root.left, val);
        }

        if(root.data.doubleValue() < val.doubleValue()){
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void buildTree(Collections<T> list){
        TreeNode root = null;
        idx = idx+1;
        for(int index=0; index< list.size(); index++){
            root = insert(root, list.get(index));
            idx = idx + 1;
        }
        this.root = root;
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
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelorder(TreeNode root){
        Queue<TreeNode> q = new Queue<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()) {
                    break;
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

    public boolean searchVal(TreeNode root, T val){
        TreeNode currNode = root;
        while(currNode != null){
            if(currNode.data.doubleValue() == val.doubleValue()) {
                return true;
            }

            if(currNode.data.doubleValue() > val.doubleValue()) {
                currNode = currNode.left;
            }

            if(currNode.data.doubleValue() < val.doubleValue()) {
                currNode = currNode.right;
            }
        }
        return false;   
    }

    public boolean search(T val) {
        return this.searchVal(this.root, val);
    }


}
