```java
class Solution {
    long[][][] dp;
    int mod = 1_000_000_007;

    public int dieSimulator(int n, int[] rollMax) {
        dp = new long[n + 1][7][16];
        for (long[][] row : dp)
            for (long[] col : row)
                Arrays.fill(col, -1);

        return (int) helper(n, 0, 0, rollMax, 0);
    }

    private long helper(int n, int dice, int prev, int[] rollMax, int runs) {
        if (n == dice)
            return 1;

        if (dp[dice][prev][runs] != -1) // Fix: Corrected the array index
            return dp[dice][prev][runs];

        long ans = 0;
        int[] temp = rollMax.clone(); // Fix: Cloned the array to avoid modifying the original
        for (int i = 1; i <= 6; i++) {
            if (prev != 0 && i == prev && temp[i - 1] <= runs) // Fix: Replaced rollMax with temp
                continue;
            if (i == prev)
                ans = (ans + helper(n, dice + 1, i, temp, runs + 1)) % mod; // Fix: Replaced rollMax with temp
            else
                ans = (ans + helper(n, dice + 1, i, temp, 1)) % mod; // Fix: Replaced rollMax with temp
        }

        dp[dice][prev][runs] = ans;
        return ans;
    }
}
```