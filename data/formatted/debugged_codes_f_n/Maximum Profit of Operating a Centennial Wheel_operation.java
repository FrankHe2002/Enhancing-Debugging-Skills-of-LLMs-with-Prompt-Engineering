```java
// Runtime: 9 ms (Top 80.7%) | Memory: 55.64 MB (Top 69.2%)

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotation = 0;
        int cust = 0;
        int profit = Integer.MIN_VALUE;
        int prRotation = 0;
        int cSit = 0;

        for (int i = 0; i < customers.length; i++) {
            cust += customers[i];
            rotation++;

            int prof = 0;
            if (cust >= 4) {
                cust = cust - 4;
                cSit += 4;
            } else {
                cSit += cust;
                cust = 0;
            }
            prof = cSit * boardingCost - rotation * runningCost;
            if (prof > profit) {
                profit = prof;
                prRotation = rotation;
            }
        }
        while (cust > 0) {
            rotation++;

            int prof = 0;
            if (cust >= 4) {
                cust = cust - 4;
                cSit -= 4;
            } else {
                cSit += cust;
                cust = 0;
            }
            prof = cSit * boardingCost - rotation * runningCost;

            if (prof > profit) {
                profit = prof;
                prRotation = rotation;
            }
        }
        if (profit > 0) return prRotation;
        return -1;
    }
}
```