package basics;

public class Trie  {

    Node root = new Node();

    public class Node {
        Node children[] = new Node[26];
        boolean eow;

        Node(){
            for(int i=0; i<children.length; i++) {
                this.children[i] = null;
            }
        }
    }

    public void insert(String word){
        word = word.toLowerCase();
        Node currNode = root;
        for(int i=0; i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(currNode.children[idx] == null){
                currNode.children[idx] = new Node();
            }

            if(i == word.length()-1) {
                currNode.children[idx].eow = true;
            }
        }
    }

    public boolean search(String word){
        word = word.toLowerCase();
        Node currNode = root;
        for(int i=0; i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(currNode.children[idx] == null){
                return false;
            }

            if(i == word.length()-1 && currNode.children[idx].eow == false) {
                return false;
            }
        }
        return true;
    }
}
