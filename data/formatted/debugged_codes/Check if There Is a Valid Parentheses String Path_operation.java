class Solution {
    static Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new Boolean[101][101][201];
        if (grid[0][0] == ')') {
            return false;
        }
        if (grid[m - 1][n - 1] == '(') {
            return false;
        }
        return solve(grid, 0, 0, m, n, 0, 0);
    }

    public static boolean solve(char[][] grid, int i, int j, int m, int n, int open, int close) {
        if (grid[i][j] == '(') {
            open++;
        } else {
            close++;
        }
        if (close > open) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return open == close;
        }
        if (dp[i][j][open - close] != null) {
            return dp[i][j][open - close];
        }
        if (i == m - 1) {
            return dp[i][j][open - close] = solve(grid, i, j + 1, m, n, open, close);
        }
        if (j == n - 1) {
            return dp[i][j][open - close] = solve(grid, i + 1, j, m, n, open, close);
        }
        boolean op = solve(grid, i + 1, j, m, n, open, close) || solve(grid, i, j + 1, m, n, open, close);
        return dp[i][j][open - close] = op;
    }
}