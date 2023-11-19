```java
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int neg = 0;
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    neg++;
                }
                ans += Math.abs(num);
                if (min > Math.abs(num))
                    min = Math.abs(num);
            }
        }
        if (neg % 2 == 0)
            return ans;
        else
            return ans - 2 * min;
    }
}
```