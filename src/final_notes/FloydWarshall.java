package final_notes;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall{

    private final int nov; // number of vertices
    private final int[][] dist; // stores all-pairs shortest distances
    private final List<List<Edge>> adj; // adjacency list

    public FloydWarshall(int nov) {
        this.nov = nov;
        dist = new int[nov][nov];
        adj = new ArrayList<>(nov);

        // Initializing adjacency list and distance matrix
        for (int i = 0; i < nov; i++) {
            adj.add(new ArrayList<>());
            // Initializing all distances to infinity
            for (int j = 0; j < nov; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
            // Changing the distance of a vertex to itself to 0
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int w) {
        adj.get(source).add(new Edge(dest, w)); // add edge from u to v with weight
        dist[source][dest] = w; // update the distance from u to v
    }

    public void floydWarshall() {
        //Time complexity: O(V^3) where V is the number of vertices in the graph because we have 3 nested loops.

        // floyd-warshall algorithm implementation
        for (int k = 0; k < nov; k++) {
            for (int i = 0; i < nov; i++) {
                for (int j = 0; j < nov; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Printing the result of floyd-warshall algorithm
        for (int i = 0; i < nov; i++) {
            for (int j = 0; j < nov; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }


    }

    // Inner class to represent an edge in the graph
    private static class Edge {
        int dest; // destination vertex
        double w;

        public Edge(int dest, double w) {
            this.dest = dest;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        FloydWarshall graph = new FloydWarshall(6);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 4);
        graph.addEdge(0, 3, 6);
        graph.addEdge(0, 5, 11);

        graph.addEdge(1, 4, 8);

        graph.addEdge(2, 1, 7);

        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 5, 9);

        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 2, 5);
        graph.addEdge(4, 5, 3);

        graph.addEdge(5, 2, 2);

        graph.floydWarshall();
    }
}