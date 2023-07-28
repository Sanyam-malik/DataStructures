package basics;
public class Tree<T> {
    T parent;
    TreeNode left;
    TreeNode right;

    public class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;
    }
    
}
