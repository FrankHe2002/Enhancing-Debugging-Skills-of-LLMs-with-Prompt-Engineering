Bug Type: Syntax Error

Reasoning: In the provided code, a semicolon is missing at the end of the line `ArrayList<ArrayList<Integer>> adj = new ArrayList<>()`. Java requires each statement to end with a semicolon. Adding the missing semicolon at the end of the line fixes this syntax error.

Fixed Code:
```java
import java.util.ArrayList;

class Solution {
    int count = 0;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] vis = new boolean[n];
        for (int i : restricted) {
            vis[i] = true;
        }
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] ii : edges) {
            adj.get(ii[0]).add(ii[1]);
            adj.get(ii[1]).add(ii[0]);
        }
        dfs(0, vis);
        return count;
    }

    private void dfs(int node, boolean[] vis) {
        vis[node] = true;
        count++;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis);
            }
        }
    }
}
```