package basics;

public class Trie  {

    Node root = new Node();

    public class Node {
        public Node[] children;
        public boolean eow;

        public Node() {
            children = new Node[26];
            for(int i=0; i< children.length; i++) {
                children[i] = null;
            }
        }
    }

    public void insert(String word) {
        word = word.toLowerCase();
        Node currNode = root;
        for(int index =0; index< word.length(); index++) {
            int idx = word.charAt(index) - 'a';

            if(currNode.children[idx] == null) {
                currNode.children[idx] = new Node();
            }

            if(index == word.length()-1) {
                currNode.children[idx].eow = true;
            }

            currNode = currNode.children[idx];
        }
    }

    public void insertAll(Collections<String> words) {
        for(int outIndex = 0; outIndex< words.size(); outIndex++) {
            String word = words.get(outIndex).toLowerCase();
            Node currNode = root;
            for(int index =0; index< word.length(); index++) {
                int idx = word.charAt(index) - 'a';

                if(currNode.children[idx] == null) {
                    currNode.children[idx] = new Node();
                }

                if(index == word.length()-1) {
                    currNode.children[idx].eow = true;
                }

                currNode = currNode.children[idx];
            }
        }
    }

    public boolean search(String key) {
        key = key.toLowerCase();
        Node currNode = root;
        for(int index =0; index< key.length(); index++) {
            int idx = key.charAt(index) - 'a';

            if(currNode.children[idx] == null) {
                return false;
            }

            if(index == key.length()-1 && currNode.children[idx].eow == false) {
                return false;
            }

            currNode = currNode.children[idx];
        }
        return true;
    }

}
