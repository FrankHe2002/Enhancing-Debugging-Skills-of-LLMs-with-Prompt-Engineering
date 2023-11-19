```java
import java.util.Arrays;

// Runtime: 3 ms (Top 83.40%) | Memory: 42.5 MB (Top 73.57%)
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
```