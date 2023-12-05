```java
// Runtime: 44 ms (Top 62.29%) | Memory: 74.7 MB (Top 66.20%)
class Solution {
    public int maxIceCream(int[] costs, int coins) {

        //Greedy Approach
        //a. sort cost in increasing order

        Arrays.sort(costs);

        int count = 0;
        for (int cost : costs) {

            //b. check remaining coin is greater or equal than current ice-cream cost
            if (coins - cost >= 0) {
                coins -= cost;
                count++;
            } else {
                break; // No need to iterate further if remaining coins can't purchase the ice cream
            }
        }

        return count;
    }
}
```