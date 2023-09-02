package basics;

public class AdjacencyMatrix {
    
    private int[][] adjacencyMatrix;
    private int numVertices;
    private String graph;

    public AdjacencyMatrix(int numVertices, String graph) {
        this.numVertices = numVertices;
        this.graph = graph;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        if(graph.equalsIgnoreCase(Graph.GRAPH_UNDIRECTED)){
            adjacencyMatrix[dest][src] = weight; // For undirected graph
        }
    }

    public void removeEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = 0;
        if(graph.equalsIgnoreCase(Graph.GRAPH_UNDIRECTED)){
            adjacencyMatrix[dest][src] = 0; // For undirected graph
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

            for(int index=0;index<numVertices;index++) {
                int dest = adjacencyMatrix[vertex][index];
                if (!visited[dest]) {
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

            for(int index=0;index<numVertices;index++) {
                int dest = adjacencyMatrix[vertex][index];
                if (!visited[dest]) {
                    visited[dest] = true;
                    stack.push(dest);
                }
            }
        }

        System.out.println();
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}