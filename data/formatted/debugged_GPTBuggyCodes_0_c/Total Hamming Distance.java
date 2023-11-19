Bug type: Logic Error / Off-by-one error

Reasoning process:
- The code calculates the total Hamming distance for all pairs of elements in the input array.
- It uses a 2D array `cnt` to store the count of 0s and 1s at each bit position for all elements encountered so far.
- The outer loop iterates through each element in the input array.
- The inner loop iterates through each bit position (from 0 to 30) of the current element.
- The bug is located in the inner loop where the loop condition is currently set to `j < 31`.
- The correct loop condition should be `j < 32` because the loop needs to iterate one more time to cover the 32nd bit position.
- The bug causes the code to not consider the 32nd bit position for calculating the total Hamming distance.

Fix:
Change the loop condition from `j < 31` to `j < 32`. This change will make the loop iterate one more time and cover the 32nd bit position.

```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int[][] cnt = new int[2][32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                int idx = (nums[i] >> j) & 1;
                total += cnt[idx ^ 1][j];
                cnt[idx][j]++;
            }
        }
        return total;
    }
}
```