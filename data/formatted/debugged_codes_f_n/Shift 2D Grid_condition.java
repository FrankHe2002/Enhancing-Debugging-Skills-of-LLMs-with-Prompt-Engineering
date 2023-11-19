```java
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] arr = new int[m][n];

        k = k % (m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { // fix: changed `>=` to `<`
                int column = (j + k) % n;
                int row = (i + ((j + k) / n)) % m;
                arr[row][column] = grid[i][j];
            }
        }
        return (List) Arrays.asList(arr);
    }
}
```