package tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Utility function to find all paths from source to destination
    private void findAllPaths(int src, int dest, boolean[] visited, List<Integer> path, List<List<Integer>> result) {
        visited[src] = true;
        path.add(src);

        if (src == dest) {
            // Destination reached, add the current path to the result
            result.add(new ArrayList<>(path));
        } else {
            for (Integer neighbor : adj[src]) {
                if (!visited[neighbor]) {
                    findAllPaths(neighbor, dest, visited, path, result);
                }
            }
        }

        // Backtrack
        visited[src] = false;
        path.remove(path.size() - 1);
    }

    // Public function to find all paths from source to destination
    public List<List<Integer>> findAllPaths(int src, int dest) {
        boolean[] visited = new boolean[V];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findAllPaths(src, dest, visited, path, result);
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int src = 2, dest = 3;
        List<List<Integer>> paths = g.findAllPaths(src, dest);

        System.out.println("All paths from " + src + " to " + dest + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
