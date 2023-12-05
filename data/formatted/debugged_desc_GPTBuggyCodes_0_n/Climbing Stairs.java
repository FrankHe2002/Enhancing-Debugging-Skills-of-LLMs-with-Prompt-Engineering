```java
class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return calculateWays(n, memo);
    }

    private int calculateWays(int n, int[] memo) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = calculateWays(n - 1, memo) + calculateWays(n - 2, memo); // changed "-" to "+"
        return memo[n];
    }
}
```