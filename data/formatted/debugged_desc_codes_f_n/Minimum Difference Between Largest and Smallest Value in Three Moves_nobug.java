```java
import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;

        int res = Math.min(nums[n - 4] - nums[0], Math.min(nums[n - 3] - nums[1], Math.min(nums[n - 2] - nums[2], nums[n - 1] - nums[3])));
  
        return res;
    }
}
```