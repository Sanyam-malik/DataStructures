// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/238

import java.math.BigInteger;

public class Addone {

    LinkedListNode head = null;

    public static class LinkedListNode {
        public int data;
        public LinkedListNode next;
    
        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // My Solution (Uses Two Much Space) 
    public void addOne(){
        LinkedListNode currNode = head;
        StringBuilder sb = new StringBuilder();
        while(currNode != null && currNode.data > -1){
            sb.append(Integer.toString(currNode.data));
            currNode = currNode.next;
        }
        BigInteger bi = new BigInteger(sb.toString());
        bi = bi.add(new BigInteger("1"));
        String s = bi.toString();
        LinkedListNode newHead = null;
        LinkedListNode newCurrent = null;
        for(Character ch : s.toCharArray()) {
            LinkedListNode newNode = new LinkedListNode(Character.getNumericValue(ch));
            if(newHead == null){
                newCurrent = newNode;
                newHead = newNode;
            } else {
                newCurrent.next = newNode;
                newCurrent = newCurrent.next;
            }
        }

        if(currNode != null) {
            while(currNode != null){
                newCurrent.next = currNode;
                currNode = currNode.next;
            }   
        }
        head = newHead;
    }

    // Others Solution (CarryOver and Add)
    public static LinkedListNode addOneToList(LinkedListNode linkedListNode) {
		// Write your code here
		linkedListNode=reverse(linkedListNode); 
		
		
		LinkedListNode curr=linkedListNode;
		// while(curr != null){
		// 	System.out.print(curr.data+" -> ");
		// 	curr=curr.next;
		// }
		// System.out.println();
		// curr=linkedListNode;
		LinkedListNode prev=null;
		int carry=1;
		while(curr.data != -1){
			int add=(int)curr.data+carry;
			int rem=add%10;
			carry=add/10;
			curr.data=rem;
			prev=curr;
			curr=curr.next;
		}
		// System.out.println(carry);
		if(carry > 0){
			LinkedListNode node= new LinkedListNode(carry);
			prev.next=node;
			prev=prev.next;
			prev.next=new LinkedListNode(-1);
		}
		
		linkedListNode=reverse(linkedListNode);
		return linkedListNode;
	}

    public static LinkedListNode reverse(LinkedListNode head){
		LinkedListNode curr=head;
		LinkedListNode prev=null;
		while(curr != null){
			LinkedListNode temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		head.next=new LinkedListNode(-1);
		prev=prev.next;
		return prev;
	}


    public void insert(int x){
        LinkedListNode n = new LinkedListNode(x);
        if(head == null){
            head = n;
        }
        else {
            LinkedListNode currNode = head;
            while(currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = n;
        }
    }

    public void print(){
        LinkedListNode currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
    }

    public static void main(String args[]) {
        int arr[] = {8, 4, 5, 4, 1, 0, 6, 8, 6, 1, 4, 4, 1, 3, 6, 5, 1, 1, 7, 6, 6, -1};
        Addone o1 = new Addone();
        for(int x : arr){
            o1.insert(x);
        }
        o1.addOne();
        o1.print();
    }





}
