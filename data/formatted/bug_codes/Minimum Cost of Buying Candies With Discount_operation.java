class Solution {
    public int minimumCost(int[] cost) {
        int minCost = 0;
        int index = cost.length - 1;
        Arrays.sort(cost);
        while (index > 1) {
            minCost += cost[index] + cost[index - 1];
            index -= 3;
        }
        while (index >= 0) {
            minCost += cost[index--];
        }
        return minCost;
    }
}