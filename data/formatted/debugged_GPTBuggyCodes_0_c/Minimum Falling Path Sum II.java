Bug type: Stack Overflow Error

Reasoning process:
1. The code uses recursion to calculate the minimum falling path sum.
2. It starts from the first row and tries all the possible paths to reach the bottom row.
3. During the recursion, the `helper` function is called recursively to calculate the minimum path sum for the next row.
4. The base case is when `i` (the row index) is `n-1` (the last row).
5. However, in the `helper` function, there is a loop that iterates `k` from 0 to `n-1`, checking if `k` is not equal to `last`.
6. If `k` is not equal to `last`, it calculates the minimum of `grid[n-1][k]` and `min`.
7. The problem is that `grid[n-1][k]` is accessed, which is the value of the next row. This causes the recursion to never reach the base case and leads to a stack overflow error.

Fix:
To fix the bug, we should change `grid[n-1][k]` to `grid[i+1][k]` in the `helper` function.

```java
class Solution {
    // Recursion
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        if(n==1) return grid[0][0];
        int ans = 10000000;
        for(int i=0 ; i<n ; i++) {
            ans = Math.min(ans, grid[0][i] + helper(grid, n, 1, i));
        }
        return ans;
    }
    
    private int helper(int[][] grid, int n, int i, int last) {
        if (i == n-1) {
            int min = 100;
            for(int k=0 ; k<n ; k++) {
                if(k != last) {
                    min = Math.min(grid[i+1][k], min);
                }
            }
            return min;
        }
        
        int min = 100000000;
        for(int k=0 ; k<n ; k++) {
            if(k != last) {
                min = Math.min(min,grid[i][k] + helper(grid , n , i+1 , k));
            }
        }
        
        return min;
    }

    // DP MEMOIZATION
   /* public int minFallingPathSum(int[][] grid