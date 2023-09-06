import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {
    List<List<Edge>> list = new ArrayList<>();
    boolean isDirected = false;
    boolean isWeighted = false;
    int vertices = 0;

    public AdjacencyList(int vertices) {
        this.vertices = vertices;

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

        if(isDirected){
            List<Edge> destEdges = this.list.get(dest);
            destEdges.add(new Edge(dest, src));
        }
    }

    public void addEdge(int src, int dest, int wt) {
        List<Edge> srcEdges = this.list.get(src);
        srcEdges.add(new Edge(src, dest, isWeighted ? wt : 0));
        if(isDirected){
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

        
        if(this.isDirected) {
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
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for(Edge e: getNeighbours(vertex)) {
            if(!visited[e.dest]){
                depthFirstSearch(e.dest, visited);
            }
        }
    }

    public void topoLogicalSort(int vertex, boolean visited[], Stack<Integer> stack) {
        visited[vertex] = true;

        for(Edge e: getNeighbours(vertex)) {
            if(!visited[e.dest]){
                topoLogicalSort(e.dest, visited, stack);
            }
        }

        stack.push(vertex);
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