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
            ob2.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 0);
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 1);
        } else {
            ob3.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 0);
        }
    }

    public void addEdge(int src, int dest, int weight) {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 0);
        } else if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_MATRIX)){
            ob1.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 1);
        } else {
            ob3.addEdge(src, dest, this.type.equalsIgnoreCase(TYPE_WEIGHTED) ? weight : 0);
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

    public void findAllPaths(int src, int dest) {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_BY_ADJACENCY_LIST)){
            ob2.findAllPaths(src, dest);
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
    
}