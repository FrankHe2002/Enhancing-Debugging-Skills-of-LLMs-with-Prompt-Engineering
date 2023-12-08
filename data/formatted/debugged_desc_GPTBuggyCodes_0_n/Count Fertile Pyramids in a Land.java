```java
class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rev = new int[n][m];
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) rev[j][i] = grid[i][j]; // fixed here
        }
        return cal(grid) + cal(rev);
    }

    private int cal(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 1; i < m; ++ i) {
            for (int j = 0, cnt = 0; j < n; ++ j) {
                if (1 != grid[i][j]) cnt++; // fixed here
                else cnt = 0;
                if (0 == cnt || 0 == j) continue;
                grid[i][j] = Math.min(grid[i - 1][j - 1] + 1, (cnt + 1) >> 1);
                res += grid[i][j] - 1;
            }
        }
        return res;
    }
}
```