The bug in the provided code is in the for loop condition. The loop should run while `i < nums.length` instead of `i <= nums.length`. This is because the array is 0-indexed, so the last index is `nums.length -1` and accessing `nums[nums.length]` will cause an ArrayIndexOutOfBoundsException.

Additionally, the calculation of the index `idx` is incorrect. It should be `(nums.length - 1) / 2` instead of `(nums.length - 1) / 2 + 1`.

Below is the corrected code:

```java
import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int idx = (nums.length - 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - nums[idx]);
        }
        return sum;
    }
}
```