package basics;

import java.util.List;

public class Tree {

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
        int elem = list.get(++idx);
        if(elem == -1) {
            return null;
        } else {
            TreeNode newNode = new TreeNode(elem);
            if(idx == 0) {
                this.root = newNode;
            }
            newNode.left = insert(list);
            newNode.right = insert(list);
            return newNode;
        }
    }

    public TreeNode preorder(TreeNode node) {
        if( node == null){
            return null;
        }
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
        return root;
    }

    public TreeNode inorder(TreeNode node) {
        if( node == null){
            return null;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
        return root;
    }

    public TreeNode postorder(TreeNode node) {
        if( node == null){
            return null;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
        return root;
    }

    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.addAll(List.of(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1));
        Tree tree = new Tree();
        tree.insert(al);
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();

    }
    
}
