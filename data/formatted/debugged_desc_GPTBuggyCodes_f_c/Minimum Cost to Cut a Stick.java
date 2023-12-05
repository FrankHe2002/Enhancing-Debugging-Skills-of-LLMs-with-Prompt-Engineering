The issue in the code is that the `cut` function has incorrect recursive logic which results in an infinite loop. This is caused by the if condition `if (dp[i][j] != - 1)` not updating the `dp` array when it should. Additionally, the calculation of the cost seems to have a logical error.

The fix for the recursive logic issue and the cost calculation can be addressed by the following changes:
1. Update the `dp` array when the condition `if (dp[i][j] != - 1)` is met in the `cut` function and initialize with an added check for the base case.
2. Adjust the cost calculation to accurately represent the logic of cutting the sticks.

Here's the fixed code:
```java
import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[len + 2];
        for (int i = 1; i <= len; i++)
            arr[i] = cuts[i - 1];
        arr[0] = 0;
        arr[len + 1] = n;
        int[][] dp = new int[len + 2][len + 2];
        
        return cut(arr, 0, len + 1, dp);
    }
    
    int cut(int[] cuts, int i, int j, int[][] dp) {
        if (j - i == 1)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = cuts[j] - cuts[i] + cut(cuts, i, k, dp) + cut(cuts, k, j, dp);
            minCost = Math.min(cost, minCost);
        }

        return dp[i][j] = minCost;
    }
}
```