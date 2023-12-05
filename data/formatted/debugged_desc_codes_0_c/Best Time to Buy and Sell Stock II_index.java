The bug in the code is in the logic for calculating the profit. The condition `prices[i + 1] > prices[0]` is checking the price on the next day against the price on the first day, which is incorrect. It should instead be comparing `prices[i + 1]` with `prices[i]`.

Here's the updated code with the fix:

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, profit = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
```