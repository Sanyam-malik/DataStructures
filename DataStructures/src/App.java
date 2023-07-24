import java.util.List;

import basics.ArrayList;
import basics.LinkedList;
import basics.Queue;
import basics.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("ArrayList!");
        ArrayList<String> al = new ArrayList<String>();
        al.add("Arjun");
        al.add("Ridhi");
        al.add("Tanya");
        al.add("Chiku");
        System.out.println(al);
        al.addAll(List.of("Slvia", "Ronald"));
        System.out.println(al);
        al.remove("Tanya");
        System.out.println(al);


        System.out.println("LinkedList!");
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Arjun");
        ll.add("Ridhi");
        ll.add("Tanya");
        ll.add("Chiku");
        System.out.println(ll);
        ll.addAll(List.of("Slvia", "Ronald"));
        System.out.println(ll);
        ll.remove("Tanya");
        System.out.println(ll);


        System.out.println("Stack!");
        Stack<String> stk1 = new Stack<String>(Stack.IMPLEMENT_LINKEDLIST);
        stk1.push("Arjun");
        stk1.push("Ridhi");
        stk1.push("Tanya");
        stk1.push("Chiku");
        System.out.println(stk1);
        System.out.println(stk1.pop());
        System.out.println(stk1.peek());
        System.out.println(stk1);


        System.out.println("Queue!");
        Queue<String> que1 = new Queue<String>(Queue.IMPLEMENT_LINKEDLIST, Queue.TYPE_DOUBLE);
        que1.offer("Arjun");
        que1.offer("Ridhi");
        que1.offer("Tanya");
        que1.offer("Chiku");
        System.out.println(que1);
        System.out.println(que1.poll());
        System.out.println(que1.peek());
        System.out.println(que1);
    }
}
