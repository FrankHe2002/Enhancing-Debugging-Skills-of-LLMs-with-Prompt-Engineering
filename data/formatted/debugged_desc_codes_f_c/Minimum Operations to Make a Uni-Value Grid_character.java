The bug in the code involves incorrect array population and sort process. The index increment and initialization are also incorrect. In addition, the median calculation and the calculation of steps for making the grid uni-value can be simplified.

Fix:
```java
import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m * n];
        int index = 0;

        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        Arrays.sort(arr);

        int median = arr[(m * n) / 2];
        int steps = 0;

        for (int num : arr) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) {
                return -1;
            }

            steps += diff / x;
        }

        return steps;
    }
}
```