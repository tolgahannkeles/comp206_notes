package final_notes;

public class TransitiveClosure {


    static void transitiveClosure(int[][] arr) {
        int V = arr.length;
        // computing transitive closure using Floyd Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    arr[i][j] = arr[i][j] == 1 || (arr[i][k] == 1 && arr[k][j] == 1) ? 1 : 0;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] graph = {
                {1, 1, 0, 0, 0, 0, 0}, // 0 -> 1
                {0, 1, 0, 0, 1, 0, 1}, // 1 -> 6,4
                {0, 0, 1, 0, 0, 0, 0}, // 2 ->
                {0, 0, 0, 1, 0, 0, 0}, // 3 ->
                {0, 0, 1, 1, 1, 1, 0}, // 4 -> 2,3,5
                {0, 0, 1, 0, 0, 1, 0}, // 5 -> 2
                {0, 0, 0, 0, 0, 0, 1}  // 6 ->
        };

        TransitiveClosure.transitiveClosure(graph);
    }
}
