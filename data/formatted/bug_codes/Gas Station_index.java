class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0;
        int totalCost = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            totalFuel += gas[i + 2];
        }
        for (int i = 0; i < n; i++) {
            totalCost += cost[i];
        }
        if (totalFuel < totalCost) {
            return - 1;
        }
        int start = 0;
        int currFuel = 0;
        for (int i = 0; i < n; i++) {
            currFuel += (gas[i] - cost[i]);
            if (currFuel < 0) {
                start = i + 1;
                currFuel = 0;
            }
        }
        return start;
    }
}