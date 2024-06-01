package final_notes;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private final int nov;
    private final LinkedList<LinkedList<Integer>> adj;

    public BFS(int nov) {
        this.nov = nov;
        adj = new LinkedList<LinkedList<Integer>>();

        for (int i = 0; i < nov; i++) {
            adj.add(new LinkedList<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public void bfs(int s) {
        // Because we are visiting each vertex and each edge exactly once, the time complexity is O(V + E)
        // where V is the number of vertices and E is the number of edges in the graph.

        // marking all the vertices as not visited(By default set as false)
        boolean[] visited = new boolean[nov];

        // creating a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // marking the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // get all adjacent vertices of the dequeued vertex s
            // if a adjacent has not been visited, then mark it visited and enqueue it
            for (int n : adj.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    public static void main(String[] args) {
        BFS graph = new BFS(10);

        graph.addEdge(0, 1);
        graph.addEdge(1, 6);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 2);
        graph.addEdge(5, 2);

        System.out.println("BFS from 0:");
        graph.bfs(0);
    }
}
