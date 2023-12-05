```java
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];
        int ans = 10000000;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, grid[0][i] + helper(grid, n, 1, i));
        }
        return ans;
    }

    private int helper(int[][] grid, int n, int i, int last) {
        if (i == n - 1) {
            int min = 100;
            for (int k = 0; k < n; k++) {
                if (k != last) {
                    min = Math.min(grid[n - 1][k], min);
                }
            }
            return min;
        }

        int min = 10000000;
        for (int k = 0; k < n; k++) {
            if (k != last) {
                min = Math.min(min, grid[i][k] + helper(grid, n, i + 1, k));
            }
        }

        return min;
    }
}
```