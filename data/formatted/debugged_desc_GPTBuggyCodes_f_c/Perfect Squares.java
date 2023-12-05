There are multiple issues in the given code:

1. The `ArrayList` type is not defined, so the code would fail to compile.
2. The method signature `helper` should be either private or public. It is missing a specified access modifier.
3. The base case for finding perfect square numbers is incorrect, where it is using the `coins` list instead of checking for perfect squares. Additionally, the method is not written to find the least number of perfect square numbers.
4. Unnecessary initialization of `perfect_squares` and `dp`.

To fix these issues, the code needs to be updated to:
```java
import java.util.ArrayList;

public class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> perfect_squares = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            perfect_squares.add(i * i);
            i++;
        }
        int[] dp = new int[n + 1];
        for (i = 1; i <= n; i++) {
            dp[i] = i;
            for (int square : perfect_squares) {
                if (square <= i) {
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
        }
        return dp[n];
    }
}
```