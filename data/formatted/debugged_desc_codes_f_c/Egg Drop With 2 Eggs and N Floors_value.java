```java
// Runtime: 74 ms (Top 32.31%) | Memory: 42.5 MB (Top 12.73%)
class Solution {
    public int twoEggDrop(int n) {
        int egg = 2;
        int[][] dp = new int[n + 1][egg + 1];
        return eggDrop(n, egg, dp);
    }

    int eggDrop(int n, int egg, int[][] dp) {
        if (n <= 1 || egg == 1) return n;
        if (dp[n][egg] != 0) return dp[n][egg];
        int min = n;
        for (int i = 1; i <= n; i++) { // Change the loop condition to include the nth floor
            int eggBreak = 1 + eggDrop(i - 1, egg - 1, dp);
            int noEggBreak = 1 + eggDrop(n - i, egg, dp);
            int moves = Math.max(eggBreak, noEggBreak);
            min = Math.min(min, moves);
        }
        dp[n][egg] = min;
        return min;
    }
}
```