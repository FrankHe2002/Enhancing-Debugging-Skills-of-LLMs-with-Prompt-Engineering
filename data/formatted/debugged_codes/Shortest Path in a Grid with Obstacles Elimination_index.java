class Solution {
    int rowLen = 0;
    int colLen = 0;
    int MAXVAL = 0;

    public int shortestPath(int[][] grid, int k) {
        rowLen = grid.length;
        colLen = grid[0].length;
        MAXVAL = rowLen * colLen + 1;
        int path = shortest(grid, k, 0, 0, 0, new boolean[rowLen][colLen], new Integer[rowLen][colLen][k + 1][4]);
        return path == MAXVAL ? - 1 : path;
    }

    int shortest(int[][] grid, int k, int row, int col, int direction, boolean[][] visited, Integer[][][][] dp) {
        if (row == rowLen - 1 && col == colLen - 1 && k >= 0)
            return 0;
        if (k < 0 || row < 0 || col < 0 || row >= rowLen || col >= colLen)
            return MAXVAL;

        if (dp[row][col][k][direction] != null)
            return dp[row][col][k][direction];
        int op1 = MAXVAL;
        if (col + 1 < colLen && ! visited[row][col + 1]) {
            visited[row][col + 1] = true;
            if (grid[row][col + 1] == 0)
                op1 = shortest(grid, k, row, col + 1, 3, visited, dp) + 1;
            else
                op1 = shortest(grid, k - 1, row, col + 1, 3, visited, dp) + 1;
            visited[row][col + 1] = false;
        }
        int op2 = MAXVAL;
        if (col - 1 >= 0 && ! visited[row][col - 1]) {
            visited[row][col - 1] = true;
            if (grid[row][col - 1] == 0)