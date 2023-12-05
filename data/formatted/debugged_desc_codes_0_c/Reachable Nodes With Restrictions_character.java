The bug in the provided Java code is that the ArrayList `adj` is not initialized with a size. This will cause an `IndexOutOfBoundsException` when trying to add elements to the ArrayList `adj`.

To fix the bug:
1. Initialize the ArrayList `adj` with the size of `n` in the reachableNodes method.

Here's the updated code with the fix:

```java
import java.util.*;

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
            if (!vis[it]) {
                dfs(it, vis);
            }
        }
    }
}
```