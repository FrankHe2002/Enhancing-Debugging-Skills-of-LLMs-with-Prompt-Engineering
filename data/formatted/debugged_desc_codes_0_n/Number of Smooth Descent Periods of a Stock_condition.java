```java
// Runtime: 7 ms (Top 24.69%) | Memory: 88.4 MB (Top 55.38%)
class Solution {
    public long getDescentPeriods(int[] prices) {
        int i = 0;
        int j = 1;
        long ans = 0; // change 1 to 0
        while (j < prices.length) {
            if (prices[j - 1] - prices[j] != 1) {
                int count = j - i; // remove +1
                ans += count;
            } else {
                i = j;
                ans += 1;
            }
            j++;
        }
        return ans;
    }
}
```