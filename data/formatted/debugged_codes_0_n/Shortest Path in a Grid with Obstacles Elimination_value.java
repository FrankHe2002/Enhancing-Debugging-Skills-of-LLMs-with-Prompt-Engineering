```java
// Runtime: 735 ms (Top 5.01%) | Memory: 122.2 MB (Top 5.01%)
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

    // For each cell(row, col) explore all possible ways to reach it with minimum cost, hence we consider the direction as well
    int shortest(int[][] grid, int k, int row, int col, int direction, boolean[][] visited, Integer[][][][] dp) {
        // Reached end of the matrix
        if (row == rowLen - 1 && col == colLen - 1 && k >= 0)
            return 0;

        // Couldn't find a valid path
        if (k < 0 || row < 0 || col < 0 || row >= rowLen || col >= colLen)
            return MAXVAL;

        if (dp[row][col][k][direction] != null)
            return dp[row][col][k][direction];

        // 4 options to choose a direction
        // Go right
        int op1 = MAXVAL;
        if (col + 1 < colLen && ! visited[row][col + 1]) {
            visited[row][col + 1] = true;
            if (grid[row][col + 1] == 0)
                op1 = shortest(grid, k, row, col + 1, 3, visited, dp) + 1;
            else
                op1 = shortest(grid, k - 1, row, col + 1, 3, visited, dp) + 1;
            visited[row][col + 1] = false;
        }

        // Go left
        int op2 = MAXVAL;
        if (col - 1 >= 0 && ! visited[row][col - 1]) {
            visited[row][col - 1] = true;
           