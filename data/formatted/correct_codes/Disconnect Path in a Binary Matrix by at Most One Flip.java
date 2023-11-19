class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int first = dfs(grid, 0, 0);
        grid[0][0] = 1;
        int second = dfs(grid, 0, 0);
        return second >= 1 ? false : true;
    }

    private int dfs(int[][] g, int r, int c) {
        if (r == g.length - 1 && c == g[0].length - 1)
            return 1;
        if (r == g.length || c == g[0].length || g[r][c] == 0)
            return 0;

        g[r][c] = 0;
        if (dfs(g, r + 1, c) == 1)
            return 1;
        return dfs(g, r, c + 1);
    }
}