// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/67

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

class InsertSortedLL
{
    public Node head = null;

    public Node sortedInsert(Node head, int x)
    {
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
        } else {
            Node currNode = head;
            // Get the Last Smaller Node
            while(currNode.next != null && currNode.next.data < x)  {
                currNode = currNode.next;
            }
    
            if(currNode != null) {
                // If node has to be inserted at first place
                if(currNode.data > x && currNode.prev == null){
                    Node prevHead = currNode;
                    prevHead.prev = newNode;
                    newNode.next = prevHead;
                    head = newNode;
                }
                
                // If node is to inserted inside
                else if(currNode.next != null) {
                    // Fetching the next node 
                    Node nextNode = currNode.next;
                    // Changing prev of next node to new node
                    nextNode.prev = newNode;
                    // Assigning new node's next -> next node 
                    newNode.next = nextNode;
                    // Assigning new node's prev -> current Node
                    newNode.prev = currNode;
                    // Changing prev of next node to new node
                    currNode.next = newNode;
                
                    
                // If node has to be inserted at last place
                } else {
                    // Assigning new node's prev -> current Node
                    newNode.prev = currNode;
                    // Changing prev of next node to new node
                    currNode.next = newNode;
                    
                }
            }
        }
        return head;
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
	    int arr[] = {5, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        InsertSortedLL il = new InsertSortedLL();
        for(int x : arr){
            il.insert(x);
        }
        il.sortedInsert(il.head, 9);
        printList(il.head);
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