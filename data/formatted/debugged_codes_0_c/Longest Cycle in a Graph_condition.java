Upon reviewing the given Java code, one potential bug can be identified. 

In the `helper` method, when setting the value of `map[index]` to `total`, the current value of `map[index]` is being overwritten. However, this current value is required to restore the value of `map[index]` to its original state after the recursive call. This can lead to incorrect calculation of the longest cycle.

To fix this issue, we need to store the current value of `map[index]` before assigning `total` to it and restore this value before returning from the `helper` method.

Here's the updated code:

```java
class Solution {
    public int longestCycle(int[] edges) {
        int[] map = new int[edges.length];
        int result = - 1;

        for (int i = 0; i < edges.length; i++)
            result = Math.max(result, helper(i, 1, edges, map));

        return result;
    }

    int helper(int index, int total, int[] edges, int[] map) {
        if (index == - 1 || map[index] == - 1)
            return - 1;

        if (map[index] == 0)
            return total - map[index];

        int originalValue = map[index]; // Store the current value
        map[index] = total;
        int result = helper(edges[index], total + 1, edges, map);
        map[index] = originalValue; // Restore the original value

        return result;
    }
}
```