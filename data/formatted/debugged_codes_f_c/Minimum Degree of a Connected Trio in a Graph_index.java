Buggy Code Explanation:
The buggy code has several issues. 
1. The condition `if (graph[i][j + 2])` is incorrect because it tries to access `graph[i][j + 2]` which is out of bounds. It should be `if (graph[i][j])` to access the correct element.
2. The inner loop `for (int k = j + 1; k <= n; k++)` should start from `j + 1` instead of `j + 1` because it needs to check all distinct values of `k` after `j`.
3. The condition `if (graph[i][k] && graph[j][k])` incorrectly checks for `graph[i][k]` instead of `graph[i][k] && graph[j][k]`. It should only consider trios where there is an edge between `i`, `j`, and `k`.
4. The calculation of `result` is incorrect. It should be `result = Math.min(result, inDegree[i] + inDegree[j] + inDegree[k] - 6)` instead of `result = Math.min(result, inDegree[i] + inDegree[j] + inDegree[k] - 6)`.
5. The original code returns `result == Integer.MAX_VALUE ? - 1 : result` which is not necessary. The fix is to directly return `result`.

Fixed Code:
```java
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        // to store edge information
        boolean[][] graph = new boolean[n + 1][n + 1];
        //to store inDegrees to a node(NOTE: here inDegree and outDegree are same because it is Undirected graph)
        int[] inDegree = new int[n + 1];

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;

            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (graph[i][j]) {
                    for (int k = j + 1; k <= n; k++) {
                        if (graph[i][k] &&