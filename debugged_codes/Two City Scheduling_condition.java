class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c1[1] - c1[0], c2[1] - c2[0])); // smallest to biggest
        int minCost = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            minCost += i < n/2? costs[i][0] : costs[i][1]; // First half -> A; Last half -> B
        }
        return minCost;
    }
}