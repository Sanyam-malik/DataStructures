import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public static final String WEIGHTED_GRAPH = "weighted";
    public static final String UNWEIGHTED_GRAPH = "unweighted";

    public static final String DIRECTED_GRAPH = "directed";
    public static final String UNDIRECTED_GRAPH = "undirected";
    
    private AdjacencyList list;
    int vertices = 0;

    Graph(int vertices) {
        this.vertices = vertices;
        list = new AdjacencyList(vertices);
    }

    Graph(int vertices, boolean isDirected, boolean isWeighted) {
        this.vertices = vertices;
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
        list.depthFirstSearch(src, vis);
        System.out.println();
    }

    public void printAllPaths(int src, int dest) {
        boolean[] vis = new boolean[vertices];
        list.printAllPairs(src, dest, ""+src, vis);
    }

    public void topoLogicalSort() {
        boolean[] vis = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!vis[i]) {
                list.topoLogicalSort(i, vis, stack);
            }
        }
        
        System.out.println("Topological sort: ");
        while(!stack.isEmpty()) {
            int v = stack.pop();
            String placeholder = !stack.isEmpty() ? "->": "";
            System.out.print(v+placeholder);
        }
    }

    public boolean hasCycle(int src) {
        boolean[] vis = new boolean[vertices];
        return list.containsCycle(src, vis);
    }

    public void dijkstra(int src) {
        boolean[] vis = new boolean[vertices];
        list.dijkstra(vis, src);
    }

    public void bellmanFord() {
        list.bellmanFord();
    }

    public void floydWarshall() {
        list.floydWarshall();
    }

    public void primAlgorithm(int src) {
        boolean[] vis = new boolean[vertices];
        list.primAlgorithm(vis, src);
    }

    public void kosarajuAlgorithm() {
       list.kosarajuAlgorithm();
    }

    public void tarzanAlgorithm() {
       list.tarzanAlgorithm();
    }

    public void printGraph() {
        list.printGraph();
    }

    public static void main(String args[]) {
        Graph g = new Graph(5, false, true);
        /* for others (4)
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 20);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);
        g.addEdge(3, 0, 15);
        g.breadthFirstSearch(0);
        g.depthFirstSearch(0);
        g.printAllPaths(0, 3);
        */

        /* for topological sort (6)
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topoLogicalSort();
        */
        
        /* for directed graph (4)
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g.hasCycle(0));
        */

        /* for dijstra and bellman (9)
        g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);
        g.dijkstra(0);
        g.bellmanFord();
        */
        
        g.addEdge(0, 1, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);

        g.primAlgorithm(0);
        g.printGraph();
        
    }

    
}
