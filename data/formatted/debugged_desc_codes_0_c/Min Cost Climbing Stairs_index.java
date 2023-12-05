The bug in the given Java code is in the for loop where the variable "i" is used to access the array "a". The array index "a[-1]" is incorrect and should be "a[i]" instead. This is likely a typographical error.

Additionally, the loop should go up to "cost.length + 1" as the array "a" is initialized with a length of "cost.length + 1".

Here's the corrected code:

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a[] = new int[cost.length + 1];
        a[0] = cost[0];
        a[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {
            a[i] = Math.min(cost[i] + a[i - 1], cost[i] + a[i - 2]);
        }
        return Math.min(a[cost.length], a[cost.length - 1]); // return the minimum cost to reach the top floor
    }
}
```