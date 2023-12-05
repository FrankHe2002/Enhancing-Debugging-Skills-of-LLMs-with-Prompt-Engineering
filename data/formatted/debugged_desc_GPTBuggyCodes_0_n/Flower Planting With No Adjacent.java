```java
import java.util.Arrays;

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < paths.length; i++) {
            int u = paths[i][0] - 1;
            int v = paths[i][1] - 1;
            graph[u][v] = true;
            graph[v][u] = true;
        }
        int[] colored = new int[n];
        boolean[] available = new boolean[4];
        Arrays.fill(colored, 0);
        for (int i = 0; i < n; i++) {
            Arrays.fill(available, true);
            for (int j = 0; j < n; j++) {
                if (graph[i][j] && colored[j] != 0) {
                    available[colored[j] - 1] = false;
                }
            }
            for (int k = 0; k < 4; k++) {
                if (available[k]) {
                    colored[i] = k + 1;
                    break;
                }
            }
        }
        return colored;
    }
}
```