The bug in the provided code is a logical error in the comparison condition within the for loop. 

In the line `int val = nums[i];`, the `nums[i]` index is out of bounds when `i` is equal to `nums.length`. Since array indices start from 0, the valid indices for the array `nums` are from 0 to `nums.length - 1`. So, the for loop should run until `i < nums.length`, not `i <= nums.length`.

To fix this bug, we need to change the comparison condition in the for loop from `i <= nums.length` to `i < nums.length`. 

Here's the updated code:

```java
class Solution {
    public int partitionDisjoint(int[] nums) {
        int mts = nums[0]; // max till scan
        int mtp = nums[0]; // max till partition
        int idx = 0;

        for (int i = 1; i < nums.length; i++) { // fix: changed <= to <
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

Now the code should correctly find the partition point and return the desired index.