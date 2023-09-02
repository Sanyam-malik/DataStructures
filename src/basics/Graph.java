package basics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    public static final String WEIGHTED_GRAPH = "weighted";
    public static final String UNWEIGHTED_GRAPH = "unweighted";

    public static final String DIRECTED_GRAPH = "directed";
    public static final String UNDIRECTED_GRAPH = "undirected";
    
    AdjacencyList list;
    int vertices = 0;

    Graph(int vertices) {
        this.vertices = vertices;
        list = new AdjacencyList(vertices);
    }

    Graph(int vertices, boolean isDirected, boolean isWeighted) {
        list = new AdjacencyList(vertices, isDirected, isWeighted);
    }

    public void addEdge(int src, int dest) {
        list.addEdge(src, dest);
    }

    public void addEdge(int src, int dest, int wt) {
        list.addEdge(src, dest, wt);
    }

    public void removeEdge(int src, int dest) {
        list.removeEdge(src, dest);
    }

    public List<AdjacencyList.Edge> getNeighbours(int vertex) {
        return list.getNeighbours(vertex);
    }

    public void breadthFirstSearch(int src) {
        boolean[] vis = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;
        list.breadthFirstSearch(queue, vis);   
    }

    public void depthFirstSearch(int src) {
        boolean[] vis = new boolean[vertices];
        vis[src] = true;
        list.depthFirstSearch(src, vis);
        System.out.println();
    }

    public void printGraph() {
        list.printGraph();
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 20);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);
        g.addEdge(3, 0, 15);
        g.breadthFirstSearch(0);
        g.depthFirstSearch(0);
        g.printGraph();
    }

    
}
