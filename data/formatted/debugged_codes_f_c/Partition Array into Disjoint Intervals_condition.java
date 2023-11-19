The bug in the provided code is that the loop iterates until `i <= nums.length`, causing an `ArrayIndexOutOfBoundsException` error. The loop should iterate until `i < nums.length` to stay within the bounds of the array.

Additionally, there is an issue with the assignment of `mts` and `mtp` variables. The values should be swapped because `mtp` represents the maximum value until the partition, while `mts` represents the maximum value until the current scan.

To fix these issues, the loop condition should be changed to `i < nums.length` and the assignments of `mts` and `mtp` should be swapped.

Fixed code:
```java
class Solution {
    public int partitionDisjoint(int[] nums) {
        int mts = nums[0]; // max till scan
        int mtp = nums[0]; // max till partition
        int idx = 0;

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val < mtp) {
                idx = i;
                mtp = mts;
            }

            mts = Math.max(mts, val);
        }

        return idx + 1;
    }
}
```