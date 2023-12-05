```java
import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c1[0] - c1[1], c2[0] - c2[1])); // Sort from low to high
        int minCost = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            minCost += costs[i][0] + costs[i + n][1]; // Add the costs for the first half to city A and the second half to city B
        }
        return minCost;
    }
}
```