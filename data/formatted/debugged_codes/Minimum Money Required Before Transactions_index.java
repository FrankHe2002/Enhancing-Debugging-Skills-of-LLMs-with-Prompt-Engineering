class Solution {
    public long minimumMoney(int[][] txs) {
        long netLosingCost = 0;
        int maxCashBack = Integer.MIN_VALUE;
        int maxCost = 0;
        for (int[] t : txs) {
            if (t[3] > t[1]) {
                netLosingCost += t[0] - t[1];
                maxCashBack = Math.max(maxCashBack, t[1]);
            } else {
                maxCost = Math.max(maxCost, t[0]);
            }
        }
        return netLosingCost + Math.max(maxCashBack, maxCost);
    }
}