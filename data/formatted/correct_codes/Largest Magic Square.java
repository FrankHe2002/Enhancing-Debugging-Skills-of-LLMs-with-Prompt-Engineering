class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowPrefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            rowPrefix[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                rowPrefix[i][j] = rowPrefix[i][j - 1] + grid[i][j];
            }
        }
        int[][] columnPrefix = new int[m][n];
        for (int i = 0; i < n; i++) {
            columnPrefix[0][i] = grid[0][i];
            for (int j = 1; j < m; j++) {
                columnPrefix[j][i] = columnPrefix[j - 1][i] + grid[j][i];
            }
        }

        int result = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int l = Math.min(m - i, n - j);
                for (int k = l; k > result; k--) {
                    if (magic(i, j, k, grid, rowPrefix, columnPrefix)) {
                        result = k;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean magic(
            int i, int j, int l, int[][] grid, int[][] rowPrefix, int[][] columnPrefix) {
        int target = rowPrefix[i][j + l - 1] - rowPrefix[i][j] + grid[i][j];
        for (int k = 0; k < l; k++) {
            if (rowPrefix[i + k][j + l - 1] - rowPrefix[i + k][j] + grid[i + k][j] != target) {
                return false;
            }
        }
        for (int k = 0; k < l; k++) {
            if (columnPrefix[i + l - 1][j + k] - columnPrefix[i][j + k] + grid[i][j + k] != target) {
                return false;
            }
        }
        int diagonal = 0;
        for (int k = 0; k < l; k++) {
            diagonal += grid[i + k][j + k];
        }

        if (diagonal != target) {
            return false;
        }
        for (int k = 0; k < l; k++) {
            diagonal -= grid[i + l - 1 - k][j + k];
        }

        return diagonal == 0;
    }
}