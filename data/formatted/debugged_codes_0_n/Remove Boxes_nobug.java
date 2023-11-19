```java
class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        return calculatePoints(boxes, dp, 0, n - 1, 0);
    }

    private int calculatePoints(int[] boxes, int[][][] dp, int i, int j, int k) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }

        int starti = i, startk = k;

        while (i + 1 <= j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }

        int result = (k + 1) * (k + 1) + calculatePoints(boxes, dp, i + 1, j, 0);

        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                result = Math.max(result,
                        calculatePoints(boxes, dp, i + 1, m - 1, 0) + calculatePoints(boxes, dp, m, j, k + 1));
            }
        }

        dp[starti][j][startk] = result;
        return result;
    }
}
```