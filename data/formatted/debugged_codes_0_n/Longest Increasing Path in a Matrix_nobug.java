```java
// Runtime: 24 ms (Top 22.67%) | Memory: 61.2 MB (Top 10.43%)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int longestPath = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int longest = dfs(matrix, i, j, memo);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];
        int[][] dirs = {{- 1, 0}, {0, 1}, {1, 0}, {0, - 1}};
        int max = 0;
        for (int k = 0; k < dirs.length; k++) {
            int x = dirs[k][0] + i;
            int y = dirs[k][1] + j;
            if (isValid(matrix, x, y) && matrix[x][y] > matrix[i][j]) {
                int longest = dfs(matrix, x, y, memo);
                max = Math.max(max, longest);
            }
        }
        memo[i][j] = 1 + max;
        return memo[i][j];
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return false;
        return true;
    }
}
```