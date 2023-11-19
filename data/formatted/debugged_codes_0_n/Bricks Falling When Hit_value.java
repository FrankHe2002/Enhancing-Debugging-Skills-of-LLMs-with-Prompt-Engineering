```java
class Solution {
    int[][] dirs = new int[][] {{1, 0}, {- 1, 0}, {0, 1}, {0, - 1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        for (int i = 0; i < hits.length; i++) {
            if (grid[hits[i][0]][hits[i][1]] == 1) {
                grid[hits[i][0]][hits[i][1]] = - 1;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            markAndCountStableBricks(grid, 0, i);
        }

        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int row = hits[i][0];
            int col = hits[i][1];

            if (grid[row][col] == 1) {
                continue;
            }

            grid[row][col] = 1;
            if (! isStable(grid, row, col)) {
                continue;
            }

            res[i] = markAndCountStableBricks(grid, hits[i][0], hits[i][1]) - 1;
        }

        return res;
    }

    private int markAndCountStableBricks(int[][] grid, int row, int col) {
        if (grid[row][col] == 0 || grid[row][col] == - 1) {
            return 0;
        }

        grid[row][col] = 2;
        int stableBricks = 1;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
                continue;
            }

            if (grid[r][c] == 0 || grid[r][c] == - 1 || grid[r][c] == 2) {
                continue;
            }

            stableBricks += markAndCountStableBricks(grid, r, c);
        }

        return stableBricks;
    }

    private boolean isStable(int[][] grid, int row, int col) {
        if (row == 0) {
            return true;
       