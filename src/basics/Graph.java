package basics;

public class Graph {

    public static final String IMPLEMENT_BY_ADJACENCY_LIST = "adjacency_list";

    public static final String IMPLEMENT_BY_ADJACENCY_MATRIX = "adjacency_matrix";

    public static final String IMPLEMENT_BY_EDGE_LIST = "edge_list";

    public static final String TYPE_WEIGHTED = "weighted";

    public static final String TYPE_UNWEIGHTED = "unweighted";

    public static final String GRAPH_DIRECTED = "directed";

    public static final String GRAPH_UNDIRECTED = "undirected";

    private String implementation;

    private String graph;

    private String type;

    private int numVertices;

    private AdjacencyMatrix ob1;
    private AdjacencyList ob2;
    private EdgeList ob3;

    public Graph(int numVertices) {
        this.implementation = IMPLEMENT_BY_ADJACENCY_LIST;
        this.graph = GRAPH_UNDIRECTED;
        this.type = TYPE_WEIGHTED;
        this.numVertices = numVertices;
        this.initGraph();
    }

    public Graph(String implementation, String graph, String type, int numVertices) {
        this.implementation = implementation;
        this.graph = graph;
        this.type = type;
        this.numVertices = numVertices;
        this.initGraph();
    }

    public void addEdge(int src, int dest) {
        int weight = 0;
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : null);
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 1);
        } else {
            ob3.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : null);
        }
    }

    public void addEdge(int src, int dest, int weight) {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : null);
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 1);
        } else {
            ob3.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : null);
        }
    }
    
    public void removeEdge(int src, int dest) {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.removeEdge(src, dest);
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.removeEdge(src, dest);
        } else {
            ob3.removeEdge(src, dest);
        }
    }

    public void printGraph() {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.printGraph();
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.printGraph();
        } else {
            ob3.printGraph();
        }
    }

    public void bfs() {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.bfs();
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.bfs();
        } else {
            ob3.bfs();
        }
    }

    public void dfs() {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.dfs();
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.dfs();
        } else {
            ob3.dfs();
        }
    }

    private void initGraph(){
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2 = new AdjacencyList(numVertices, graph);
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1 = new AdjacencyMatrix(numVertices, graph);   
        } else {
            ob3 = new EdgeList(graph);
        }
    }


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
            if(graph.equalsIgnoreCase(GRAPH_UNDIRECTED)){
                adjacencyMatrix[dest][src] = weight; // For undirected graph
            }
        }
    
        public void removeEdge(int src, int dest) {
            adjacencyMatrix[src][dest] = 0;
            if(graph.equalsIgnoreCase(GRAPH_UNDIRECTED)){
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
                        break;
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

    public class AdjacencyList {
        private ArrayList<LinkedList<Edge>> adjacencyList;
        private int numVertices;
        private String graph;
        
        public class Edge {
            int dest;
            Integer weight;
        
            public Edge(int dest, int weight) {
                this.dest = dest;
                this.weight = weight;
            }
        }

        public AdjacencyList(int numVertices, String graph) {
            this.numVertices = numVertices;
            this.graph = graph;
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new LinkedList<>());
            }
        }

        public void addEdge(int src, int dest, Integer weight) {
            adjacencyList.get(src).add(new Edge(dest, weight));
            if(graph.equalsIgnoreCase(GRAPH_UNDIRECTED)) {
                // For undirected graph, add the reverse edge as well
                adjacencyList.get(dest).add(new Edge(src, weight));
            }
        }

        public void removeEdge(int src, int dest) {
            for(int index=0; index < adjacencyList.get(src).size(); index++) {
                if (adjacencyList.get(src).get(index).dest == dest) {
                    adjacencyList.get(index).remove(index);
                }
            }

            if(graph.equalsIgnoreCase(GRAPH_UNDIRECTED)) {
                // For undirected graph, add the reverse edge as well
                for(int index=0; index < adjacencyList.get(dest).size(); index++) {
                    if (adjacencyList.get(dest).get(index).dest == src) {
                        adjacencyList.get(dest).remove(index);
                    }
                }
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
    
                for (Edge edge : adjacencyList.get(vertex)) {
                    if (!visited[edge.dest]) {
                        visited[edge.dest] = true;
                        queue.offer(edge.dest);
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
    
            System.out.println("DFS traversal starting from vertex " + startVertex + ": ");
    
            while (!stack.isEmpty()) {
                int vertex = stack.pop();
                System.out.print(vertex + " ");
    
                for (Edge edge : adjacencyList.get(vertex)) {
                    if (!visited[edge.dest]) {
                        visited[edge.dest] = true;
                        stack.push(edge.dest);
                        break;
                    }
                }
            }
    
            System.out.println();
        }

        public void printGraph() {
            for (int i = 0; i < numVertices; i++) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (Edge edge : adjacencyList.get(i)) {
                    System.out.print(edge.dest + " (Weight: " + edge.weight + ") ");
                }
                System.out.println();
            }
        }
    }

    public class EdgeList {
        private ArrayList<Edge> edgeList;
        private String graph;

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
            if(graph.equalsIgnoreCase(GRAPH_UNDIRECTED)){
                edgeList.add(new Edge(dest, src, weight)); // For undirected graph
            }
        }

        public void removeEdge(int src, int dest) {
            ArrayList<Integer> removedEdges = new ArrayList<>();
            for(Edge edge : edgeList) {
                if(edge.src == src && edge.dest == dest) {
                    removedEdges.add(edgeList.contains(edge));
                }
                if(graph.equalsIgnoreCase(GRAPH_UNDIRECTED)) {
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
                        break;
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
    
}