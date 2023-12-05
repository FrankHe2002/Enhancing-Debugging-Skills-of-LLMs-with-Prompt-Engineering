```java
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col], -1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void dfs(int[][] grid, int row, int col, int color, int newColor) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != color) {
            return;
        }
        grid[row][col] = newColor;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || Math.abs(grid[newRow][newCol]) != color) {
                continue;
            }
            dfs(grid, newRow, newCol, color, newColor);
        }
        if (row > 0 && row < grid.length - 1 && col > 0 && col < grid[0].length - 1 &&
            (grid[row - 1][col] == color || grid[row + 1][col] == color || grid[row][col - 1] == color || grid[row][col + 1] == color)) {
            grid[row][col] = -color;
        }
    }
}
```