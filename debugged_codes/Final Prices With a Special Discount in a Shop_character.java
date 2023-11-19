// Runtime: 0 ms (Top 100%) | Memory: 38.8 MB (Top 100%)
class Solution {
    public int[] finalPrices(int[] prices) {
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}