```java
class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int[][] dp = new int[mat.length][5001];
        return minDiff(mat, 0, target, 0, dp);
    }

    public int minDiff(int[][] mat, int index, int target, int val, int[][] dp) {
        if (index == mat.length) {
            return Math.abs(val - target);
        }
        if (dp[index][val] != 0) {
            return dp[index][val];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            res = Math.min(res, minDiff(mat, index + 1, target, val + mat[index][i], dp));
        }

        return dp[index][val] = res;
    }
}
```