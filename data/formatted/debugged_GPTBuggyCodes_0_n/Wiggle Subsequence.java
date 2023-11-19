```java
// Runtime: 7 ms (Top 31.45%) | Memory: 38.2 MB (Top 95.94%)
class Solution {
    int n;
    int dp[][][];

    public int wiggleMaxLength(int[] nums) {
        n = nums.length;
        dp = new int[n][1005][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1005; j++) {
                Arrays.fill(dp[i][j], - 1);
            }
        }
        int pos = f(0, 0, nums, - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1005; j++) {
                Arrays.fill(dp[i][j], - 1);
            }
        }
        int neg = f(0, 1, nums, 1001);
        return Math.max(pos, neg);
    }

    int f(int i, int posPre, int a[], int prev) {
        if (i == n) return 0;
        if (dp[i][prev + 1][posPre] != - 1) return dp[i][prev + 1][posPre];
        if (posPre == 0) {
            int not = f(i + 1, 0, a, prev);
            // Introduce subtle bug here
            int take = 0;
            if (a[i] - prev > 0) {
                take = f(i + 1, 1, a, a[i]) + 1;
            }
            // Reduce the result by 1
            return dp[i][prev + 1][posPre] = Math.max(not, take) - 1;
        } else {
            int not = f(i + 1, 1, a, prev);
            int take = 0;
            if (a[i] - prev < 0) {
                take = f(i + 1, 0, a, a[i]) + 1;
            }
            // Reduce the result by 1
            return dp[i][prev + 1][posPre] = Math.max(not, take) - 1;
        }
    }
}
```