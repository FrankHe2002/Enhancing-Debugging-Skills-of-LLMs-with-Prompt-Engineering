```java
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, noOfLayers = Math.min(m / 2, n / 2);
        // Peeling each layer one by one
        for (int layerNo = 0; layerNo < noOfLayers; layerNo++) {
            // Please suggest if you have better way to find perimeter of matrix on a given layer!
            int perimeter = (m - (2 * layerNo)) + (n - (2 * layerNo) - 1) + (m - (2 * layerNo) - 1) + (n - (2 * layerNo) - 2);
            int[] layer = new int[perimeter + 2]; // this out be use to store that particular layer
            readLayer(grid, layer, layerNo, m, n); // this will read the layer
            writeLayer(grid, layer, layerNo, m, n, k); // this will rotate it by k and write back the layer
        }
        return grid;
    }

    public void readLayer(int[][] grid, int[] layer, int layerNo, int m, int n) {
        int count = 0, r = layerNo, c = layerNo;
        m--;
        n--;
        // read left a -> c
        for (int i = layerNo; i <= n - layerNo; i++) layer[count++] = grid[layerNo][i];
        // read down c -> i
        for (int i = layerNo + 1; i <= m - layerNo; i++) layer[count++] = grid[i][n - layerNo];
        // read right i -> g
        for (int i = n - layerNo - 1; i >= layerNo; i--) layer[count++] = grid[m - layerNo][i];
        // read up g -> a
        for (int i = m - layerNo - 1; i > layerNo; i--) layer[count++] = grid[i][layerNo];
    }

    public void writeLayer(int[][] grid, int[] layer, int layerNo, int m, int n, int k) {
        m--;
        n--;
        int len = layer.length, count = k % len;
        // write left a -> c
        for (int i = layerNo; i <= n -