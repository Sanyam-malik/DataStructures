import java.util.List;

import basics.ArrayList;
import basics.BinarySearch;
import basics.BubbleSort;
import basics.Graph;
import basics.HashTable;
import basics.LinkedList;
import basics.MergeSort;
import basics.Queue;
import basics.QuickSort;
import basics.SelectionSort;
import basics.Stack;
import basics.Tree;

public class App {
    public static void main(String[] args) throws Exception {
       /*  System.out.println("ArrayList!");
        ArrayList<String> al = new ArrayList<String>();
        al.add("Arjun");
        al.add("Ridhi");
        al.add("Tanya");
        al.add("Chiku");
        System.out.println(al);
        al.addAll(List.of("Slvia", "Ronald"));
        System.out.println(al);
        al.remove("Tanya");
        System.out.println(al); */


        /* System.out.println("LinkedList!");
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Arjun");
        ll.add("Ridhi");
        ll.add("Tanya");
        ll.add("Chiku");
        System.out.println(ll);
        ll.addAll(List.of("Slvia", "Ronald"));
        System.out.println(ll);
        ll.remove("Tanya");
        System.out.println(ll); */


        /* System.out.println("Stack!");
        Stack<String> stk1 = new Stack<String>(Stack.IMPLEMENT_LINKEDLIST);
        stk1.push("Arjun");
        stk1.push("Ridhi");
        stk1.push("Tanya");
        stk1.push("Chiku");
        System.out.println(stk1);
        System.out.println(stk1.pop());
        System.out.println(stk1.peek());
        System.out.println(stk1); */


        /* System.out.println("Queue!");
        Queue<String> que1 = new Queue<String>(Queue.IMPLEMENT_LINKEDLIST, Queue.TYPE_DOUBLE);
        que1.offer("Arjun");
        que1.offer("Ridhi");
        que1.offer("Tanya");
        que1.offer("Chiku");
        System.out.println(que1);
        System.out.println(que1.poll());
        System.out.println(que1.peek());
        System.out.println(que1); */

        /* 
        System.out.println("Sorting!");
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.addAll(List.of(23, 11, 60, 32, 41, 57, 34,78));

        QuickSort<Integer> mergeSort = new QuickSort<Integer>(al, QuickSort.TYPE_ASCENDING);
        mergeSort.sort();
        System.out.println(al);
        */

        /* System.out.println("BinarySearch!");
        BinarySearch<Integer> bSearch = new BinarySearch<>(al, BinarySearch.TYPE_DESCENDING);
        if(bSearch.contains(78) > -1) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        } */

        /* ArrayList<Integer> al = new ArrayList<Integer>();
        al.addAll(List.of(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1));
        System.out.println("Tree!");
        Tree<Integer> tree = new Tree<>();
        tree.buildTree(al);
        tree.traverseTree(Tree.TRAVERSE_TYPE_LEVELORDER); */

        /* HashTable<String, Integer> hashTable= new HashTable<>();
        hashTable.put("Berlin", 20);
        hashTable.put("New York", 290);
        hashTable.remove("Berlin");
        System.out.println(hashTable.entrySet()); */

        Graph graph = new Graph(Graph.IMPLEMENT_BY_ADJACENCY_LIST, Graph.GRAPH_DIRECTED, Graph.TYPE_UNWEIGHTED, 6);
        /* graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3); */

        /*
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 3);
        graph.printGraph();
        graph.dfs();
        */

        Graph g = new Graph(5);
		
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 4);
        g.printGraph();
        g.dfs();
    }
}
