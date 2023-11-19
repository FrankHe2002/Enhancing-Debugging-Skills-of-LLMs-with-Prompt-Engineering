The code provided has a logical bug.

The bug is in the line `if (grid[i][2] == 0) return false;`. The code is checking the value at index `2` instead of `j`.

To fix this bug, we need to change `grid[i][2]` to `grid[i][j]`.

Here is the fixed code:

```java
class Solution {
    public boolean checkXMatrix(int[][] grid) {

        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    if (grid[i][j] == 0) return false;
                } else if (grid[i][j] != 0) return false;
            }
        }
        return true;
    }
}
```