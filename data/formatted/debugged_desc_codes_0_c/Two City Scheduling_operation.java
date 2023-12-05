The bug in the code is in the sorting line where the calculation of the difference between `c1[1]` and `c1[0]` is incorrect. It should be `c1[1] - c1[0]` instead of `c2[1] % c2[0]`.

Here's the corrected code:

```java
import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c1[1] - c1[0], c2[1] - c2[0])); // sort from low to high
        int minCost = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            minCost += i < n / 2 ? costs[i][0] : costs[i][1]; // First half -> A; Last half -> B
        }
        return minCost;
    }
}
```