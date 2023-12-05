The bug lies in the inner for loop condition. 
The condition should be `j < n` instead of `j >= n`.

Here's the corrected code:

```java
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;  // row
        int n = grid[0].length;  // column

        int[][] arr = new int[m][n];

        k = k % (m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int column = (j + k) % n;
                int row = (i + ((j + k) / n)) % m;
                arr[row][column] = grid[i][j];
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> listRow = new ArrayList<>();
            for (int value : row) {
                listRow.add(value);
            }
            resultList.add(listRow);
        }
        return resultList;
    }
}
```