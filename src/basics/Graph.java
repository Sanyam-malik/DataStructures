package basics;

public class Graph {

    public class AdjacencyMatrix {
        private int[][] adjacencyMatrix;
        private int numVertices;
    
        public AdjacencyMatrix(int numVertices) {
            this.numVertices = numVertices;
            adjacencyMatrix = new int[numVertices][numVertices];
        }
    
        public void addEdge(int src, int dest, int weight) {
            adjacencyMatrix[src][dest] = weight;
            adjacencyMatrix[dest][src] = weight; // For undirected graph
        }
    
        public void removeEdge(int src, int dest) {
            adjacencyMatrix[src][dest] = 0;
            adjacencyMatrix[dest][src] = 0; // For undirected graph
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

        public class Edge {
            int dest;
            int weight;
        
            public Edge(int dest, int weight) {
                this.dest = dest;
                this.weight = weight;
            }
        }

        public AdjacencyList(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new LinkedList<>());
            }
        }

        public void addEdge(int src, int dest, int weight) {
            adjacencyList.get(src).add(new Edge(dest, weight));
            // For undirected graph, add the reverse edge as well
            adjacencyList.get(dest).add(new Edge(src, weight));
        }

        public void removeEdge(int src, int dest) {
            for(int index=0; index < adjacencyList.get(src).size(); index++) {
                if (adjacencyList.get(src).get(index).dest == dest) {
                    adjacencyList.get(index).remove(index);
                }
            }

            for(int index=0; index < adjacencyList.get(dest).size(); index++) {
                if (adjacencyList.get(dest).get(index).dest == src) {
                    adjacencyList.get(dest).remove(index);
                }
            }
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

        public class Edge {
            int src;
            int dest;
            int weight;
        
            public Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }

        private ArrayList<Edge> edgeList;
        public EdgeList(int numVertices) {
            edgeList = new ArrayList<Edge>();
        }

        public void addEdge(int src, int dest, int weight) {
            edgeList.add(new Edge(src, dest, weight));
            edgeList.add(new Edge(dest, src, weight)); // For undirected graph
        }

        public void removeEdge(int src, int dest) {
            ArrayList<Integer> removedEdges = new ArrayList<>();
            for(Edge edge : edgeList) {
                if(edge.src == src && edge.dest == dest) {
                    removedEdges.add(edgeList.contains(edge));
                }
                // For undirected graph
                if(edge.src == dest && edge.dest == src) {
                    removedEdges.add(edgeList.contains(edge));
                }
            }

            for(Integer index: removedEdges){
                edgeList.remove(index);
            }
        }

        public void printGraph() {
            for (Edge edge : edgeList) {
                System.out.println("Edge from " + edge.src + " to " + edge.dest + " with weight " + edge.weight);
            }
        }
    }
    
}