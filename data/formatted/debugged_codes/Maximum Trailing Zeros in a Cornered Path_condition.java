class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dph = new int[m][n][3];
        int[][][] dpv = new int[m][n][3];
        int hmax0 = 0;
        int vmax0 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                int two = 0;
                int five = 0;
                if (j >= 1) {
                    two = dph[i][j - 1][1];
                    five = dph[i][j - 1][2];
                }
                while (curr > 0 && curr % 2 == 0) {
                    two++;
                    curr /= 2;
                }
                while (curr > 0 && curr % 5 == 0) {
                    five++;
                    curr /= 5;
                }
                dph[i][j][1] = two;
                dph[i][j][2] = five;
                dph[i][j][0] = Math.min(dph[i][j][1], dph[i][j][2]);
            }
            hmax0 = Math.max(hmax0, dph[i][n - 1][0]);
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int curr = grid[i][j];
                int two = 0;
                int five = 0;
                if (i >= 1) {
                    two = dpv[i - 1][j][1];
                    five = dpv[i - 1][j][2];
                }
                while (curr > 0 && curr % 2 == 0) {
                    two++;
                    curr /= 2;
                }
                while (curr > 0 && curr % 5 == 0) {
                    five++;
                    curr /= 5;
                }
                dpv[i][j][1] = two;
                dpv[i][j][2] = five;
                dpv[i][j][0] = Math.min(dpv[i][j][1], dpv[i][j][2]);
            }