package basics;

public class EdgeList {
    private ArrayList<Edge> edgeList;
    private String graph;
    private int numVertices;

    public class Edge {
        int src;
        int dest;
        Integer weight;
    
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public EdgeList(String graph) {
        this.graph = graph;
        edgeList = new ArrayList<Edge>();
    }

    public void addEdge(int src, int dest, Integer weight) {
        edgeList.add(new Edge(src, dest, weight));
        if(graph.equalsIgnoreCase(Graph.GRAPH_UNDIRECTED)){
            edgeList.add(new Edge(dest, src, weight)); // For undirected graph
        }
    }

    public void removeEdge(int src, int dest) {
        ArrayList<Integer> removedEdges = new ArrayList<>();
        for(Edge edge : edgeList) {
            if(edge.src == src && edge.dest == dest) {
                removedEdges.add(edgeList.contains(edge));
            }
            if(graph.equalsIgnoreCase(Graph.GRAPH_UNDIRECTED)) {
                // For undirected graph
                if(edge.src == dest && edge.dest == src) {
                    removedEdges.add(edgeList.contains(edge));
                }
            }
        }

        for(Integer index: removedEdges){
            edgeList.remove(index);
        }
    }

    public void bfs() {
        int startVertex = 0;
        boolean[] visited = new boolean[numVertices]; // Tracks visited vertices
        Queue<Integer> queue = new Queue<>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        System.out.print("BFS traversal starting from vertex " + startVertex + ": ");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for(Edge edge : edgeList){
                int src = edge.src;
                int dest = edge.dest;
                if (src == vertex && !visited[dest]) {
                    visited[dest] = true;
                    queue.offer(dest);
                }
            }
        }

        System.out.println();
    }

    public void dfs() {
        int startVertex = 0;
        boolean[] visited = new boolean[numVertices]; // Tracks visited vertices
        Stack<Integer> stack = new Stack<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        System.out.print("DFS traversal starting from vertex " + startVertex + ": ");

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(vertex + " ");

            for(Edge edge : edgeList){
                int src = edge.src;
                int dest = edge.dest;
                if (src == vertex && !visited[dest]) {
                    visited[dest] = true;
                    stack.push(dest);
                }
            }
        }

        System.out.println();
    }
    
    public void printGraph() {
        for (Edge edge : edgeList) {
            System.out.println("Edge from " + edge.src + " to " + edge.dest + " with weight " + edge.weight);
        }
    }
}