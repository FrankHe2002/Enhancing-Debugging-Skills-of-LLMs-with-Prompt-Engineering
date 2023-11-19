Bug Type: Array Out of Bounds Error

Reasoning: In the provided code, there is an array out of bounds error specifically in the inner loop condition `j < 31`. The inner loop iterates from 0 to 30, but it should iterate from 0 to 31 because the bitwise operation `(nums[i] >> j) & 1` should also include the 31st bit.

Fix: Change the inner loop condition from `j < 31` to `j <= 31`.

Fixed Code:
```java
// Runtime: 24 ms (Top 19.37%) | Memory: 53.8 MB (Top 78.38%)
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int[][] cnt = new int[2][32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= 31; j++) {
                int idx = (nums[i] >> j) & 1;
                total += cnt[idx ^ 1][j];
                cnt[idx][j]++;
            }
        }
        return total;
    }
}
```