```java
class Solution {
    public int minimumCost(int[] cost) {
        int minCost = 0;
        int index = cost.length - 1;
        Arrays.sort(cost);
        // add items in pairs of 2, the 3rd one getting it for free.
        while (index > 1) {
            minCost += cost[index] + cost[index - 1];
            index -= 3;
        }
        // add the remaining 1, 2 items, if any.
        while (index >= 0) {
            minCost += cost[index--];
        }
        return minCost;
    }
}
```