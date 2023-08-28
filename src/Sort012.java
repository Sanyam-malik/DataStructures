// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/456

import java.util.Arrays;

class Node
{
    int data;
    Node next, prev;
    
    Node(int item)
    {
        data = item;
        next = prev = null;
    }
}

public class Sort012 {

    public Node head = null;

    /* 
    public void quicksort(int start, int end, int arr[]) {
        if(start < end) {
            int pivot = partition(start, end, arr);
            quicksort(start, pivot-1, arr);
            quicksort(pivot+1, end, arr);
        }
    }

    private int partition(int start, int end, int arr[]) {
        int pivot = end;
        int idx = start - 1;
        int index = start;

        while(index < pivot) {
            if(arr[index] < arr[pivot]){
                int temp = arr[++idx];
                arr[idx] = arr[index];
                arr[index] = temp;
            }
            index = index+1;
        }

        int temp = arr[++idx];
        arr[idx] = arr[end];
        arr[end] = temp; 
        return idx;
    }
 */
    public void insert(int x){
        Node n = new Node(x);
        if(head == null){
            head = n;
        }
        else {
            Node currNode = head;
            while(currNode.next != null){
                currNode = currNode.next;
            }
            n.prev = currNode;
            currNode.next = n;
        }
    }

    public void sort(){
        int arr[] = new int[get_count(head)];
        Node currNode = head;
        int index = 0;
        while(currNode != null) {
            arr[index] = currNode.data;
            currNode = currNode.next;
            index++;
        }

        Arrays.sort(arr);
        //quicksort(0, arr.length-1, arr);
        

        Node newHead = null;
        currNode = null;
        for(int a: arr){
            Node newNode = new Node(a);
            if(newHead == null){
                newHead = newNode;
                currNode = newNode;
            } else {
                currNode.next = newNode;
                currNode = currNode.next;
            }
        }
        head = newHead; 
    }

    public int get_count(Node head){
        int count = 0;
        Node currNode = head;
        while(currNode != null){
            currNode = currNode.next;
            count++;
        }
        return count;
    }

    public void print(){
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 0, 2, 1, 0, 2, 1};
        Sort012 o1 = new Sort012();
        for(int x : arr){
            o1.insert(x);
        }
        o1.sort();
        o1.print();
    }
}
