package basics;

import java.util.List;

public class LinkedList<T> {
    
    Node head = null;
    
    public class Node {
        T data;
        Node next;

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            if(next != null){
                return data.toString()+", "+next.toString();
            } else {
                return data.toString();
            }
        }
    }
    
    public void add(T data){
        if(head == null){
            Node newNode = new Node(data, null);
            head = newNode;
        } else {
            Node currNode = head;
            if(currNode.next != null){
                while(currNode.next != null) {
                    currNode = currNode.next;
                }
            }
            currNode.next = new Node(data, null);
        }
    }

    public void addAll(List<T> dataList){
        for(T data: dataList){
            this.add(data);
        }
    }

    public void remove(T data){
        if(head != null && this.contains(data)){
            if(head.data != data) {
                Node prevNode = head;
                while(prevNode.next != null) {
                    if(prevNode.next.data == data){
                        prevNode.next = prevNode.next.next;
                        break;
                    } else {
                        prevNode = prevNode.next;
                    }
                }
            } else {
                head = head.next;
            }
        }
    }

    public void remove(int index){
        if(head != null && (index >= 0 && index < this.size())){
            if(index == 0){
                head = head.next;
            } else {
                int iterator = 1;
                Node prevNode = head;
                while(prevNode.next != null) {
                    if(iterator == index){
                        prevNode.next = prevNode.next.next;
                        break;
                    } else {
                        prevNode = prevNode.next;
                        iterator++;
                    }
                }
            }
        }
    }

    public T get(int index){
        Node currNode = head;
        int iterator = 0;
        while(currNode != null) {
            if(iterator == index){
                return currNode.data;
            } else {
                currNode = currNode.next;
                iterator++;
            }
        }
        return null;
    }

    public boolean contains(T data){
        Node currNode = head;
        while(currNode != null) {
            if(currNode.data == data){
                return true;
            } else {
                currNode = currNode.next;
            }
        }
        return false;
    }

    public void clear(){
        head = null;
    }

    public int size(){
        int iterator = 0;
        Node currNode = head;
        while(currNode != null) {
            currNode = currNode.next;
            iterator++;
        }
        return iterator;
    }

    @Override
    public String toString() {
        return head.toString();
    }
    
}
