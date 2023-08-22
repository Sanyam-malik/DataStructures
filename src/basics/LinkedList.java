package basics;

import java.util.Iterator;

public class LinkedList<T> implements Collections<T>, Iterable<T>{

    private Node head;
    public int size;

    public class Node{
        private T data;
        public Node prev;
        public Node next;

        public Node(T data){
            this.data = data;
        }
    }

    public void add(T elem) {
        Node newNode = new Node(elem);
        if(head != null){
            Node currNode = head;
            while(currNode.next != null) { currNode = currNode.next; }
            currNode.next = newNode;
            newNode.prev = currNode;
        } else {
            head = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        } else {
            Node currNode = head;
            int currIndex = 0;
            while(currNode != null) { 
                if(currIndex == index){
                    return currNode.data;
                }
                currNode = currNode.next;
                currIndex++;
            }
            return null;
        }
    }


    public T set(int index, T elem) {
        if (index > size - 1 || index < 0) {
            return null;
        } else {
            Node currNode = head;
            int currIndex = 0;
            while(currNode != null) { 
                if(currIndex == index){
                    T temp = currNode.data;
                    currNode.data = elem;
                    return temp;
                }
                currNode = currNode.next;
                currIndex++;
            }
            return null;
        }
    }

    public T remove(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        } else {
            Node currNode = head;
            int currIndex = 0;
            while(currNode != null) { 
                if(currIndex == index){
                    T temp = currNode.data;
                    Node prevNode = currNode.prev;
                    Node nextNode = currNode.next;

                    // if index input is 0
                    if(prevNode == null){
                        head = nextNode;
                    }
                    // if index input is last index
                    else if(nextNode == null){
                        prevNode.next = null;
                    }
                    else {
                        prevNode.next = nextNode;
                        nextNode.prev = prevNode;
                    }
                    return temp;
                }
                currNode = currNode.next;
                currIndex++;
            }
            return null;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node currNode = head;
            while(currNode != null) { 
                sb.append(currNode.next != null ? currNode.data.toString()+", " : currNode.data.toString());
                currNode = currNode.next;
            }
        return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

    public class LinkedListIterator<T> implements Iterator<T> {

        LinkedList<T> list;
        int currIndex = 0;
        
        public LinkedListIterator(LinkedList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return currIndex+1 < this.list.size;
        }

        @Override
        public T next() {
            return this.list.get(currIndex++);
        }

    }

    public static void main(String args[]){
        LinkedList<Integer> linkList = new LinkedList<>();
        linkList.add(10);
        linkList.add(40);
        linkList.add(80);
        linkList.add(20);
        linkList.set(1, 45);
        linkList.remove(0);
        System.out.println(linkList);
    }
    
}
