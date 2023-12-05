The bug in the given Java code is in the inner for loop. The condition `for (int j = 0; j >= n; j++)` is incorrect. It should be `for (int j = 0; j < n; j++)`. Additionally, the final output is not correctly formatted as a list of lists.

Fix:
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> listRow = new ArrayList<>();
            for (int val : row) {
                listRow.add(val);
            }
            result.add(listRow);
        }
        
        return result;
    }
}
```