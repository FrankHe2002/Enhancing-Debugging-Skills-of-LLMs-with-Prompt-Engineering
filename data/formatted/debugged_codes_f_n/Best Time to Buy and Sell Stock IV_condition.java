```java
class Solution {
    public int maxProfit(int k, int[] prices) {
        int transactions = k;
        int N = prices.length;
        int[][][] dp = new int[N][2][k + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                for (int tran = 0; tran <= k; tran++) {
                    dp[i][j][tran] = -1;
                }
            }
        }
        return profit(0, 1, k, prices, dp);
    }

    int profit(int index, int buy, int transactions, int[] prices, int[][][] dp) {
        if (transactions == 0) {
            return 0;
        }
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][buy][transactions] != -1) {
            return dp[index][buy][transactions];
        }
        int profit = 0;
        if (buy != 1) {
            profit = Math.max(-prices[index] + profit(index + 1, 0, transactions, prices, dp),
                    0 + profit(index + 1, 1, transactions, prices, dp));
        } else {
            profit = Math.max(prices[index] + profit(index + 1, 1, transactions - 1, prices, dp),
                    0 + profit(index + 1, 0, transactions, prices, dp));
        }
        dp[index][buy][transactions] = profit;
        return dp[index][buy][transactions];
    }
}
```