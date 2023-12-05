The bug type in the given Java code is an `ArrayIndexOutOfBoundsException` and logical errors.

Explanation:
1. In the `findMax` method, there is an `ArrayIndexOutOfBoundsException` issue due to the loop condition being `i <= nums.length`. This results in an attempt to access an index out of the array's bounds. Changing it to `i < nums.length` fixes this issue.
2. In the `numIslands` method, the bug is in the condition `grid[j][j] == '1'` inside the loop, where it should be `grid[i][j] == '1'`. This change is necessary to properly check the grid for '1's and avoid an `ArrayIndexOutOfBoundsException`.

Fix:
```java
class Solution {
    public int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}
```