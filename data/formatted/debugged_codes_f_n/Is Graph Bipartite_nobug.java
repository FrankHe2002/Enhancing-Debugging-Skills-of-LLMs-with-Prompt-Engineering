```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;

                while (!q.isEmpty()) {
                    int cur = q.poll();

                    for (int x : graph[cur]) {
                        if (colors[x] == 0) {
                            colors[x] = -colors[cur];
                            q.offer(x);
                        } else if (colors[x] != -colors[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
```