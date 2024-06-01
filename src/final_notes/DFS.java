package final_notes;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    private final int nov; // Number of vertices
    private final ArrayList<ArrayList<Integer>> adj; // Adjacency Lists

    // Constructor
    public DFS(int num_vertices) {
        this.nov = num_vertices;
        adj = new ArrayList<>(num_vertices);
        for (int i = 0; i < num_vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        // adding the edge to the list
        adj.get(v).add(w);
    }

    public void dfs(int v) {
        // Time complexity: O(V + E) where V is the number of vertices in the graph and E is the number of edges in the graph.
        // Here, the algorithm visits each vertex and edge once, resulting in a time complexity of O(V + E).

        // creating isVisited array to keep track of visited vertices
        boolean[] isVisited = new boolean[nov];

        // creating a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // pushing the first element  to the stack
        stack.push(v);

        while (!stack.empty()) {
            v = stack.peek();
            stack.pop();

            // Stack may contain same vertex twice. So we need to print the popped item only if it is not visited.
            if (!isVisited[v]) {
                System.out.print(v + " ");
                isVisited[v] = true;
            }

            // Get all adjacent vertices of the popped vertex v If a adjacent has not been visited, then push it to the stack.
            for (Integer n : adj.get(v)) {
                if (!isVisited[n]) {
                    stack.push(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS(20);

        graph.addEdge(0, 1);
        graph.addEdge(1, 6);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 2);

        System.out.println("DFS from 0:");
        graph.dfs(0);
    }
}