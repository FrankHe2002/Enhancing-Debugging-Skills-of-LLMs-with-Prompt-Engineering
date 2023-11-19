```java
import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = 3;

        int res = Integer.MAX_VALUE;
        while (left <= 3) {
            int mini = nums[left];
            int max = nums[nums.length - right - 1];
            res = Math.min(res, max - mini);

            left++;
            right--;
        }

        return res;
    }
}
```