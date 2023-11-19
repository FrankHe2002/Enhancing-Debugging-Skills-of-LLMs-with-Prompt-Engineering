Bug type: Logic error

Reasoning process:
1. The code aims to find the maximum sum that is divisible by 3 from the given array of integers.
2. The code initializes three variables r0, r1, and r2 to store the maximum sum that leaves a remainder of 0, 1, and 2 respectively.
3. The code iterates over each integer in the array.
4. For each integer, the code calculates three new sums:
   - a = r0 + nums[i]
   - b = r1 + nums[i]
   - c = r2 + nums[i]
5. The code then updates the maximum sums for each remainder based on the new sums:
   - If the new sum is divisible by 3, the maximum sum for remainder 0 (nr0) is updated to be the maximum of the current maximum sum for remainder 0 and the new sum (a).
   - If the new sum leaves a remainder of 1, the maximum sum for remainder 1 (nr1) is updated in the same way.
   - If the new sum leaves a remainder of 2, the maximum sum for remainder 2 (nr2) is updated in the same way.
6. Finally, the code updates r0, r1, and r2 to the new maximum sums (nr0, nr1, and nr2) for the next iteration.

Bug explanation:
The bug in the code lies in the condition for updating the maximum sum for remainder 0. Instead of checking if c % 3 is not equal to 0, the code mistakenly checks if c % 3 is equal to 1.
This error causes the maximum sum for remainder 0 (nr0) to be incorrectly updated when the new sum (c) leaves a remainder of 1, resulting in incorrect computation of the maximum sum divisible by 3.

Fix:
To fix the bug, we need to change the condition from `if (c % 3 != 0)` to `if (c % 3 == 0)` in order to correctly update nr0 when c is divisible by 3.

Updated code:
```java
class Solution {

    public int maxSumDivThree(int[] nums) {
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int nr0 = r0;
            int nr1 =