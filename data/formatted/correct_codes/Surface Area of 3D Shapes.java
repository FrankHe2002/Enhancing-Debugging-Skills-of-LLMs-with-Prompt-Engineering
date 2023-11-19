class Solution {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) area += grid[i][j];
                else area += Math.abs(grid[i][j] - grid[i - 1][j]);
                if (j == 0) area += grid[i][j];
                else area += Math.abs(grid[i][j] - grid[i][j - 1]);
                if (i == n - 1) area += grid[i][j];
                if (j == n - 1) area += grid[i][j];
                if (grid[i][j] != 0) area += 2;
            }
        }
        return area;
    }
}