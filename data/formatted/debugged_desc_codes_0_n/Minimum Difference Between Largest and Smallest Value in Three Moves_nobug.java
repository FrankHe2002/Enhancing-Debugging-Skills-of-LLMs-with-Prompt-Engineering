```java
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            int mini = nums[i];
            int max = nums[nums.length - 4 + i];
            res = Math.min(res, max - mini);
        }

        return res;
    }
}
```