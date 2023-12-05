```java
// Runtime: 9 ms (Top 80.7%) | Memory: 55.64 MB (Top 69.2%)

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotatn = 0;
        int cust = 0;
        int profit = Integer.MIN_VALUE;
        int prRotn = 0;
        int cSit = 0;

        for (int i = 0; i < customers.length; i++) {
            cust += customers[i];
            rotatn++;

            int prof = 0;
            if (cust >= 4) {

                cust -= 4; // Fixed bug here
                cSit += 4;
            } else {
                cSit += cust;
                cust = 0;
            }
            prof = cSit * boardingCost - rotatn * runningCost;
            if (prof > profit) {
                profit = prof;
                prRotn = rotatn;
            }
        }
        while (cSit > 0) {
            rotatn++;

            int prof = 0;
            if (cSit >= 4) {
                cSit -= 4; // Fixed bug here
                prof = cSit * boardingCost - rotatn * runningCost;
            } else {
                prof = cSit * boardingCost - rotatn * runningCost;
                cSit = 0;
            }
            if (prof > profit) {
                profit = prof;
                prRotn = rotatn;
            }
        }
        if (profit > 0) return prRotn;
        return - 1;
    }
}
```