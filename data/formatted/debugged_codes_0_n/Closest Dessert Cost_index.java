```java
class Solution {
    int closestCost = Integer.MAX_VALUE;
    int closestCostDiff = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int base : baseCosts) {
            dfs(toppingCosts, 0, base, target);
        }
        return closestCost;
    }

    public void dfs(int[] toppingCosts, int toppingIndex, int cost, int target) {
        int costDiff = Math.abs(target - cost);
        if (costDiff < closestCostDiff || (costDiff == closestCostDiff && cost < closestCost)) {
            closestCostDiff = costDiff;
            closestCost = cost;
        }

        if (toppingIndex >= toppingCosts.length || cost > target)
            return;

        dfs(toppingCosts, toppingIndex + 1, cost, target);
        if (toppingIndex < toppingCosts.length - 1)
        	dfs(toppingCosts, toppingIndex + 1, cost + toppingCosts[toppingIndex + 1], target);
        if (toppingIndex < toppingCosts.length - 1)
        	dfs(toppingCosts, toppingIndex + 1, cost + 2 * toppingCosts[toppingIndex + 1], target);
    }
}
```