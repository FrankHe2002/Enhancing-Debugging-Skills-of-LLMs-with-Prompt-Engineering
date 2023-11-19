class Solution {
    public long getDescentPeriods(int[] prices) {
        int i = 0;
        int j = 1;
        long ans = 1;
        while (j < prices.length) {
            if (prices[j - 1] - prices[j] == 1) {
                int count = j - i + 1;
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