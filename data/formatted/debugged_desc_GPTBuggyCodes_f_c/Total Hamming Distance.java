Explanation:
The loop condition in the inner loop is incorrect - `j < 31` should be `j < 32` to correctly iterate over all 32 bits of the integer. Additionally, the bitwise operation `cnt[idx ^ 1][j]++` should be placed after the `total` variable increment (`total += cnt[idx ^ 1][j];`) to match the correct logic for calculating Hamming distance.

Fix:
```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int[][] cnt = new int[2][32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                int idx = (nums[i] >> j) & 1;
                cnt[idx][j]++;
            }
        }
        for (int j = 0; j < 32; j++) {
            total += cnt[0][j] * cnt[1][j];
        }
        return total;
    }
}
```