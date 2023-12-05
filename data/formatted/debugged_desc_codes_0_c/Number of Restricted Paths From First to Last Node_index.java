Bug type: Logical Error

Reasoning:
1. The code implements Dijkstra's algorithm to find the shortest path from node 1 to node n, but it does not properly calculate the distance of each node from node n.
2. The `dist` array is incorrectly being used to store the distance of each node from node n, which leads to incorrect calculations in the `find` method.

Code Fix:

```java
import java.util.*;

class Solution {
    int[] dp;

    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int weight = next[1];
                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(1, graph, n, dist);
    }

    private int find(int node, List<List<int[]>> graph, int n, int[] dist) {
        if (node == n) {
            return 1;
        }
        if (dp[node] != -1) {
            return dp[node];
        }
        long ans = 0;
        for (int[] next : graph.get(node)) {
            int nextNode = next[0];
            if (dist[node] > dist[nextNode]) {
                ans += find(nextNode, graph, n, dist);
            }
        }
        dp[node] = (int) (ans % 1_000_000_007);
        return dp[node];
    }
}
```
The bug was in the calculation of the distance of each node from node n and in the use of the graph data structure. The fixed code properly calculates the distance of each node from node n using Dijkstra's algorithm and performs the proper depth-first search to find the number of restricted paths. Also updated the class and method parameters to public as the original code did not declare it.