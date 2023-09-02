package basics;

import java.util.List;

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
        if(graph.equalsIgnoreCase(Graph.GRAPH_UNDIRECTED)) {
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

        if(graph.equalsIgnoreCase(Graph.GRAPH_UNDIRECTED)) {
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
                }
            }
        }

        System.out.println();
    }


    public ArrayList<ArrayList<Integer>> findAllPaths(int src, int dest) {
        ArrayList<Integer> paths = new ArrayList<>(); 
        boolean vis[] = new boolean[numVertices];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findAllUtil(src, dest, vis, paths, result);
        for(ArrayList<Integer> resultPaths: result) {
            System.out.print("[");

            for(Integer resultx: resultPaths) {
                System.out.print(resultx+"->");
            }   

            System.out.print("]");
            System.out.println();
        }
        return result;  
    }

    public void findAllUtil(int src, int dest, boolean visited[], ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        visited[src] = true;
        path.add(src);

        if (src == dest) {
            // Destination reached, add the current path to the result
            result.add(addArrayList(path));
        } else {
            for (Edge e : adjacencyList.get(src)) {
                if (!visited[e.dest]) {
                    findAllUtil(e.dest, dest, visited, path, result);
                }
            }
        }

        // Backtrack
        visited[src] = false;
        path.remove(path.size() - 1);
    }

    public ArrayList<Integer> addArrayList(ArrayList<Integer> path) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer v : path) {
            result.add(v);
        }
        return result;
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
