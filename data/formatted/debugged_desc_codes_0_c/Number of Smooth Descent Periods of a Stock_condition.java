The bug in the provided Java code is in the logic for counting the smooth descent periods. The if-else condition inside the while loop is incorrect. When the prices[j - 1] - prices[j] != 1, it doesn't necessarily mean that the current element can be part of the previous subarrays, and the computation of the count is incorrect. It should be determined if the current price is actually 1 less than the previous price.

Here's the corrected code:

```java
// Runtime: 7 ms (Top 24.69%) | Memory: 88.4 MB (Top 55.38%)
class Solution {
    public long getDescentPeriods(int[] prices) {
        int i = 0;
        int j = 1;
        long ans = 0; // change initial value to 0
        while (j < prices.length) {
            if (prices[j - 1] - prices[j] == 1) { // change condition to check if the current price is 1 less than the previous price
                int count = j - i + 1; // change count to include the current element
                ans += count;
            } else {
                i = j;
            }
            j++;
        }
        return ans;
    }
}
```