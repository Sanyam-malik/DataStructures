package basics;

public class BinarySearchTree{

    TreeNode root = null;
    int idx = -1;

    public class TreeNode{
        
        public TreeNode left, right = null;
        public int data = -1;

        public TreeNode(int data) {
            this.data = data;
        }
    }


    public TreeNode insert(ArrayList<Integer> list){
        for(int a: list) {
            this.insertRecursive(root, a);
        }
        return root;
    }

    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.data) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.data) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    // Search for a value in the binary tree
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // Recursive helper function to search for a value in the tree
    private boolean searchRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.data) {
            return true;
        }

        if (value < current.data) {
            return searchRecursive(current.left, value);
        } else {
            return searchRecursive(current.right, value);
        }
    }

}
