import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {
    List<List<Edge>> list = new ArrayList<>();
    boolean isDirected = false;
    boolean isWeighted = false;
    int vertices = 0;

    public class Pair implements Comparable<Pair>{
        int vertex;
        int wt;

        Pair(int vertex, int wt) {
            this.vertex = vertex;
            this.wt = wt;
        }

        @Override
        public int compareTo(AdjacencyList.Pair o) {
            return this.wt - o.wt;
        }
    }

    public AdjacencyList(int vertices) {
        this.vertices = vertices;
        this.isDirected = true;

        for(int i=0; i<vertices;i++) {
            list.add(new ArrayList<>());
        }
    }

    public AdjacencyList(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;

        for(int i=0; i<vertices;i++) {
            list.add(new ArrayList<>());
        }
    }

    public AdjacencyList(int vertices, boolean isDirected, boolean isWeighted) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        
        for(int i=0; i<vertices;i++) {
            list.add(new ArrayList<>());
        }
    }
    
    public class Edge {
        int src;
        int dest;
        int wt = 0;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public String toString(){
            if (wt > 0) return "["+this.src+" --("+this.wt+")--> "+this.dest+"]";
            else return "["+this.src+" -> "+this.dest+"]";
        }
    }


    public void addEdge(int src, int dest) {
        List<Edge> srcEdges = this.list.get(src);
        srcEdges.add(new Edge(src, dest));

        if(!isDirected){
            List<Edge> destEdges = this.list.get(dest);
            destEdges.add(new Edge(dest, src));
        }
    }

    public void addEdge(int src, int dest, int wt) {
        List<Edge> srcEdges = this.list.get(src);
        srcEdges.add(new Edge(src, dest, isWeighted ? wt : 0));
        if(!isDirected){
            List<Edge> destEdges = this.list.get(dest);
            destEdges.add(new Edge(dest, src, isWeighted ? wt : 0));
        }
    }

    public void removeEdge(int src, int dest) {
        List<Edge> srcEdges = this.list.get(src);
        for (Edge edge : srcEdges) {
            if (edge.dest == dest) {
                srcEdges.remove(edge);
                break;
            }
        }

        
        if(!this.isDirected) {
            List<Edge> destEdges = this.list.get(dest);
            for (Edge edge : destEdges) {
                if (edge.dest == src) {
                    destEdges.remove(edge);
                    break;
                }
            }
        }
    }

    public List<Edge> getNeighbours(int src){
        return this.list.get(src);
    }

    public void breadthFirstSearch(Queue<Integer>queue, boolean visited[]) {
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for(Edge e: getNeighbours(vertex)) {
                if(!visited[e.dest]){
                    queue.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
        System.out.println();
    }

    public void depthFirstSearch(int vertex, boolean visited[]) {
        visited[vertex] = true;
        System.out.print(vertex+ " ");

        for(Edge e: getNeighbours(vertex)) {
            if(!visited[e.dest]){
                depthFirstSearch(e.dest, visited);
            }
        }
    }

    public boolean containsCycle(int src, boolean visited[]){
        boolean rec[] = new boolean[vertices];
        return isDirected ? isDirectedCyclic(src, visited, rec) : isUnDirectedCyclic(src, -1, visited);
    }

    public boolean isDirectedCyclic(int vertex, boolean visited[], boolean rec[]) {
        visited[vertex] = true;
        rec[vertex] = true;
        for(Edge e: getNeighbours(vertex)) {
            if(rec[e.dest]) {
                return true;
            }
            else if(!visited[e.dest]){
               boolean isCycle = isDirectedCyclic(e.dest, visited, rec);
               if(isCycle) {
                    return true;
                }
            }
        }
        rec[vertex] = false;
        return false;
    }

    public boolean isUnDirectedCyclic(int vertex, int parent, boolean visited[]) {
        visited[vertex] = true;

        for(Edge e: getNeighbours(vertex)) {
            if(visited[e.dest] && vertex != parent) {
                return true;
            }
            else if(!visited[e.dest]){
                boolean isCycle = isUnDirectedCyclic(e.dest, vertex, visited);
                if(isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Topological sort */
    public void topoLogicalSort(int vertex, boolean visited[], Stack<Integer> stack) {
        visited[vertex] = true;

        for(Edge e: getNeighbours(vertex)) {
            if(!visited[e.dest]){
                topoLogicalSort(e.dest, visited, stack);
            }
        }

        stack.push(vertex);
    }

    /* dijkstra algorithm */
    public void dijkstra(boolean visited[], int src) {
        int distance[] = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src));
        distance[src] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();

            if(!visited[p.vertex]){
                visited[p.vertex] = true;
                
                for(Edge e: getNeighbours(p.vertex)) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        for(int value: distance) {
            System.out.print(value+ " ");
        }
        System.out.println();
    }

    public void bellmanFord() {
        int distance[] = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        for(int k=0; k< vertices-1; k++){
            for(int vertex = 0; vertex < list.size();vertex++) {
                for(Edge e: getNeighbours(vertex)) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                    }
                }
            }
        }

        for(int value: distance) {
            System.out.print(value+ " ");
        }
        System.out.println();
    }


    public void floydWarshall() {
        int[][] distance = new int[vertices][vertices];
        
        /* Initialize the values to infinity */
        for(int i=0; i< vertices; i++) {
            for(int j=0; j< vertices; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        /* Adding original values */
        for(int i=0; i< vertices; i++) {
            for(int j=0; j < list.get(i).size(); j++) {
                Edge e = list.get(i).get(j);
                distance[i][j] = e.wt;
            }   
        }
        
        for(int k=0; k< vertices-1; k++){
            for(int i = 0; i < vertices;i++) {
                for(int j=0; j< vertices; j++) {
                    if(distance[i][k] != Integer.MAX_VALUE && distance[j][k] != Integer.MAX_VALUE && distance[i][k]+distance[j][k] < distance[i][j]) {
                        distance[i][j] = distance[i][k]+distance[j][k];
                    }
                }
            }
        }

        // Print the shortest paths
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    /* prim's algorithm */
    public void primAlgorithm(boolean visited[], int src) {
        int mstCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src));

        while(!pq.isEmpty()) {
            Pair p = pq.poll();

            if(!visited[p.vertex]){
                mstCost+=p.wt;
                visited[p.vertex] = true;
                
                for(Edge e: getNeighbours(p.vertex)) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(!visited[v]) {
                        pq.add(new Pair(v, wt));
                    }
                }
            }
        }
        System.out.println("MST Cost: "+mstCost);
    }

    /* Get All Paths */
    public void printAllPairs(int vertex, int dest, String path, boolean visited[]) {
        if(vertex == dest) {
            System.out.println();
            System.out.println("Path: "+path);
        }
        

        for(Edge e: getNeighbours(vertex)) {
            visited[vertex] = true;
            if(!visited[e.dest]){
                printAllPairs(e.dest, dest, path+"->"+e.dest, visited);
            }
            visited[vertex] = false;
        }
    }

    public void printGraph() {
        int vertex = 0;
        for(List<Edge> edges : list) {
            System.out.println("Vertex "+vertex + " : " +edges);
            vertex++;
        }
    }





}