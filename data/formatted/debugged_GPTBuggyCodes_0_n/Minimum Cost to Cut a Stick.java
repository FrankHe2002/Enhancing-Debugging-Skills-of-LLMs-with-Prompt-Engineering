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
        int[][] dp = new int[len + 2][len + 2]; // change dp size
        
        for (int i = 0; i <= len + 1; i++) // change loop range
            for (int j = 0; j <= len + 1; j++) // change loop range
                dp[i][j] = -1;

        return cut(arr, 1, len + 1, dp); // change arguments
    }

    int cut(int[] cuts, int i, int j, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) // change loop range
    {
            int cost = cuts[j] - cuts[i - 1]; // remove recursive calls
            cost += cut(cuts, i, k, dp); // add first cut value
            cost += cut(cuts, k + 1, j, dp); // add second cut value
            mini = Math.min(cost, mini);
        }

        return dp[i][j] = mini;
    }
}
```