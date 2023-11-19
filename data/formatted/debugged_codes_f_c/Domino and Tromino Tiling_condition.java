Bug type: Logic Error/Array Indexing Error

Reasoning process:
1. The code initializes an array `dp` with a length of `n + 3`.
2. It assigns values to the elements at indices 0, 1, and 2.
3. The loop is intended to calculate the values for the remaining indices of the array.
4. The loop condition is `i >= n`, which causes an out-of-bounds error because the loop starts from index 3 and iterates until `i` becomes less than `n`.
5. The loop should instead run until `i <= n` to calculate the values for indices 3 to `n`.

Fix:
```java
class Solution {
    public int numTilings(int n) {
        long[] dp = new long[n + 3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return (int) dp[n];
    }
}
```