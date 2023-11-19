```java
// Runtime: 9 ms (Top 80.7%) | Memory: 55.64 MB (Top 69.2%)

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotation = 0;
        int customer = 0;
        int profit = Integer.MIN_VALUE;
        int profitRotation = 0;
        int currentSituation = 0;

        for (int i = 0; i < customers.length; i++) {
            customer += customers[i];
            rotation++;

            int currProfit = 0;
            if (customer >= 4) {
                customer = customer - 4;
                currentSituation += 4;
            } else {
                currentSituation += customer;
                customer = 0;
            }
            currProfit = currentSituation * boardingCost - rotation * runningCost;
            if (currProfit > profit) {
                profit = currProfit;
                profitRotation = rotation;
            }
        }
        while (customer > 0) {
            rotation++;

            int currProfit = 0;
            if (customer >= 4) {
                customer = customer - 4;
                currentSituation += 4;
            } else {
                currentSituation += customer;
                customer = 0;
            }
            currProfit = currentSituation * boardingCost - rotation * runningCost;

            if (currProfit > profit) {
                profit = currProfit;
                profitRotation = rotation;
            }
        }
        if (profit > 0) return profitRotation;
        return -1;
    }
}
```