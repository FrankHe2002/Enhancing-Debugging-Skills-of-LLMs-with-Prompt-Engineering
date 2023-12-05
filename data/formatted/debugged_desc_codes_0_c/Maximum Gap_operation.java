The bug in the given Java code is in the loop where the maximum difference between successive elements is calculated. The bug is in the way the difference is calculated using the absolute value of `nums[i] - nums[i - 1]`, where it should be the difference between `nums[i]` and `nums[i + 1]`.

To fix the bug, the following changes need to be made:
1. The loop needs to be corrected to iterate from `i = 0` to `i < nums.length - 1`.
2. The calculation of the maximum difference should use `nums[i + 1]` instead of `nums[i - 1]`.

Here's the fixed code with minimal changes:
```java
import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        if (nums.length < 2) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.max(nums[i + 1] - nums[i], res);
        }
        return res;
    }
}
```