Bug Type: Index out of Bounds Exception

Reasoning: The error occurs in the line `dp[r + 1][c] = new Pair(grid[r][c], grid[r][c]);` where `r + 1` exceeds the maximum index for the `dp` array. The loop iterates from `grid.length - 1` down to 0, so `r + 1` will be equal to `grid.length` when `r` is 0. 

Fix: Change `dp[r + 1][c]` to `dp[r][c]` to ensure the assignment is done within the valid bounds of the array.

Fixed Code:
```java
// Runtime: 4 ms (Top 41.67%) | Memory: 43.3 MB (Top 29.76%)
class Solution {
    public class Pair {
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        Pair() {

        }

        Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    public int maxProductPath(int[][] grid) {
        Pair[][] dp = new Pair[grid.length][grid[0].length];
        for (int r = grid.length - 1; r >= 0; r--) {
            for (int c = grid[0].length - 1; c >= 0; c--) {
                if (r == grid.length - 1 && c == grid[0].length - 1) {
                    dp[r][c] = new Pair(grid[r][c], grid[r][c]);
                } else {
                    Pair hor = (c == grid[0].length - 1) ? new Pair() : dp[r][c + 1];
                    Pair ver = (r == grid.length - 1) ? new Pair() : dp[r + 1][c];
                    long min, max;
                    if (grid[r][c] >= 0) {
                        max = Math.max(hor.max, ver.max);
                        min = Math.min(hor.min, ver.min);
                    } else {
                        min = Math.max(hor.max, ver.max);
                        max = Math.min(hor.min, ver.min);
                    }
                    dp[r][c] = new Pair(min * grid[r][c], max * grid[r][c]);
                }
            }
        }
        int mod = (int) 1e9 + 7;
