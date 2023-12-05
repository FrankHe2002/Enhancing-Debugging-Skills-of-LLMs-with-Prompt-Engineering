```java
// Runtime: 24 ms (Top 22.67%) | Memory: 61.2 MB (Top 10.43%)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int longestPath = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j, memo);
                longestPath = Math.max(longestPath, memo[i][j]);
            }
        }
        return longestPath;
    }

    // Add return type for dfs method
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j]; // Return if the longest path exists
        int[][] dirs = {{- 1, 0}, {0, 1}, {1, 0}, {0, - 1}};
        int max = 0;
        for (int k = 0; k < dirs.length; k++) {
            int x = dirs[k][0] + i;
            int y = dirs[k][1] + j;
            if (isValid(matrix, x, y) && matrix[x][y] > matrix[i][j]) {
                // Get/compute the largest path for that index
                if (memo[x][y] == 0) { // If longest path doesn't exist for that path then compute it
                    memo[x][y] = dfs(matrix, x, y, memo); // Update the memo for visited points
                }
                max = Math.max(max, memo[x][y]);
            }
        }
        memo[i][j] = 1 + max;
        return memo[i][j]; // Return the longest path ending at i, j
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return false;
        return true;
    }
}
```