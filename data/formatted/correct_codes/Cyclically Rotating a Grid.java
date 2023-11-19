class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, noOfLayers = Math.min(m / 2, n / 2);
        for (int layerNo = 0; layerNo < noOfLayers; layerNo++) {
            int perimeter = (m - (2 * layerNo)) + (n - (2 * layerNo) - 1) + (m - (2 * layerNo) - 1) + (n - (2 * layerNo) - 2);
            int[] layer = new int[perimeter];
            readLayer(grid, layer, layerNo, m, n);
            writeLayer(grid, layer, layerNo, m, n, k);
        }
        return grid;
    }

    public void readLayer(int[][] grid, int[] layer, int layerNo, int m, int n) {
        int count = 0, r = layerNo, c = layerNo;
        m--;
        n--;
        for (int i = layerNo; i < n - layerNo; i++) layer[count++] = grid[layerNo][i];
        for (int i = layerNo; i < m - layerNo; i++) layer[count++] = grid[i][n - layerNo];
        for (int i = n - layerNo; i > layerNo; i--) layer[count++] = grid[m - layerNo][i];
        for (int i = m - layerNo; i > layerNo; i--) layer[count++] = grid[i][layerNo];
    }

    public void writeLayer(int[][] grid, int[] layer, int layerNo, int m, int n, int k) {
        m--;
        n--;
        int len = layer.length, count = k;
        for (int i = layerNo; i < n - layerNo; i++) {
            count %= len;
            grid[layerNo][i] = layer[count++];
        }
        for (int i = layerNo; i < m - layerNo; i++) {
            count %= len;
            grid[i][n - layerNo] = layer[count++];
        }
        for (int i = n - layerNo; i > layerNo; i--) {
            count %= len;
            grid[m - layerNo][i] = layer[count++];
        }
        for (int i = m - layerNo; i > layerNo; i--) {
            count %= len;
            grid[i][layerNo] = layer[count++];
        }
    }


}
