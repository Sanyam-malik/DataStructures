// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/253

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

public class RotateDLL {

    Node head = null;

    // Brute Force
    public void rotate(Node head, int k){
        Node currNode = head;
        int arr[] = new int[get_count(head)];
        int arrayIndex = -1;
        while(currNode !=null){
            arr[++arrayIndex] = currNode.data;
            currNode = currNode.next;
        }

        Node newHead = null;
        Node ansNode = null;
        for(int i=k; i<=arr.length-1; i++){
            // Head is being set
            if(newHead == null){
                Node newNode = new Node(arr[i]);
                ansNode = newNode;
                newHead = ansNode;
            } else {
                // New values are boing appended
                Node newNode = new Node(arr[i]);
                newNode.prev = ansNode;
                ansNode.next = newNode;
                ansNode = ansNode.next;
            }
        }
        for(int i=0; i< k; i++){
            // New values are boing appended
            Node newNode = new Node(arr[i]);
            newNode.prev = ansNode;
            ansNode.next = newNode;
            ansNode = ansNode.next;
        }
        head = newHead;
        printList(newHead);
    }

    // Optimized Approach
    public void rotateOptimum(Node head, int k){
        Node currNode = head;
        Node ansNode = null;
        Node newHead = null;

        int index = 0;
        while(currNode != null){
            if(index >= k){
                if(newHead == null){
                    Node newNode = new Node(currNode.data);
                    ansNode = newNode;
                    newHead = newNode;
                } else {
                    // New values are boing appended
                    Node newNode = new Node(currNode.data);
                    newNode.prev = ansNode;
                    ansNode.next = newNode;
                    ansNode = ansNode.next;
                }
            }
            currNode = currNode.next;
            index++;
        }

        currNode = head;
        index = 0;
        while(currNode != null){
            if(index < k){
                // New values are boing appended
                Node newNode = new Node(currNode.data);
                newNode.prev = ansNode;
                ansNode.next = newNode;
                ansNode = ansNode.next;
            } else {
                break;
            }
            currNode = currNode.next;
            index++;
        }
        printList(newHead);
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
	
	public static void main (String[] args) {
	    int arr[] = {4, 3, 9, 1, 7, 8};
        RotateDLL il = new RotateDLL();
        for(int x : arr){
            il.insert(x);
        }
        il.rotateOptimum(il.head, 4);
	}
	
	public static void printList(Node head)
	{
	    Node temp = head;
	    while(temp != null)
	    {
	        System.out.print(temp.data + " ");
	        temp = temp.next;
	    }
	}

}
