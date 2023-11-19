Bug Type: Missing semicolon

Explanation: In the provided buggy code, there is a missing semicolon at the end of the line `result += c`. This causes a syntax error as each statement in Java should end with a semicolon.

Fix: Add a semicolon at the end of the line `result += c`.

Fixed Code:
```java
// Runtime: 44 ms (Top 62.29%) | Memory: 74.7 MB (Top 66.20%)
class Solution {
    public int maxIceCream(int[] costs, int coins) {

        //Greedy Approach
        //a. sort cost in increasing order

        Arrays.sort(costs);

        int count = 0;
        for (int cost : costs) {

            //b. check remaining coin is greater or equal than current ice - cream cost
            if (coins - cost >= 0) {
                coins -= cost;
                count++;
            }
        }

        return count;
    }
}
```