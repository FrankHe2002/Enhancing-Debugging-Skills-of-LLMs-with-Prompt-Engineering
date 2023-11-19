Bug type: Sorting bug

Reasoning process:
1. The code sorts the costs array using a custom comparator that compares the difference between the second and first element of each cost (c2[1] - c2[0] and c1[1] - c1[0]).
2. However, there is a bug in the comparator logic. Instead of calculating the difference as c2[1] - c2[0], it calculates it as c2[1] % c2[0]. This will result in incorrect sorting.

Fix:
Change `Integer.compare(c2[1] % c2[0], c1[1] - c1[0])` to `Integer.compare(c2[1] - c2[0], c1[1] - c1[0])`

Updated code:
```java
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c2[1] - c2[0], c1[1] - c1[0])); // fixed the sorting logic
        int minCost = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            minCost += i < n / 2 ? costs[i][0] : costs[i][1];
        }
        return minCost;
    }
}
```