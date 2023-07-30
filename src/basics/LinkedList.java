package basics;

import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements Collections<T>, Iterable<T> {
    
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
        if(head != null && this.contains(data) > -1){
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
    
    public void set(int index, T value){
        Node currNode = head;
        int iterator = 0;
        while(currNode != null) {
            if(iterator == index){
                currNode.data = value;
            } else {
                currNode = currNode.next;
                iterator++;
            }
        }
    }

    public int contains(T data){
        Node currNode = head;
        int iterator = 0;
        while(currNode != null) {
            if(currNode.data == data){
                return iterator;
            } else {
                currNode = currNode.next;
                iterator++;
            }
        }
        return -1;
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

    @Override
    public boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    public class LinkedListIterator implements Iterator<T> {

        private LinkedList<T> list;
        private int index = -1;
        private int size = -1;

        public LinkedListIterator(LinkedList<T> list) {
            this.list = list;
            this.index = 0;
            this.size = list.size();
        }

        @Override
        public boolean hasNext() {
            return this.index + 1 <= this.size ? true : false;
        }

        @Override
        public T next() {
            T currT = list.get(index);
            index++;
            return currT;
        }
        
    }
    
}
