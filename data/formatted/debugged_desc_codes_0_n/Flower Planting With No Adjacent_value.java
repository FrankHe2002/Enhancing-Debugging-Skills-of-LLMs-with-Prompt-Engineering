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
        Arrays.fill(colored, 0);
        for (int i = 0; i < n; i++) {
            boolean[] available = new boolean[5];
            for (int j = 0; j < n; j++) {
                if (graph[i][j] && colored[j] > 0) {
                    available[colored[j]] = true;
                }
            }
            for (int c = 1; c <= 4; c++) {
                if (!available[c]) {
                    colored[i] = c;
                    break;
                }
            }
        }
        return colored;
    }
}
```