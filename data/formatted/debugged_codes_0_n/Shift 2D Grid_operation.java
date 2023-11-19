class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        k = k % (m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int column = (j + k) % n;
                int row = (i + ((j + k) / n)) % m;
                arr[row][column] = grid[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> listRow = new ArrayList<>();
            for (int num : row) {
                listRow.add(num);
            }
            result.add(listRow);
        }
        return result;
    }
}