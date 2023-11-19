```java
class Solution {

    private int getAbsoluteDifference(int a, int b) {
        return Math.abs(a - b);
    }

    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++)
            result += getAbsoluteDifference(nums[i], nums[i + 1]);

        int minLine = Integer.MAX_VALUE;  // fix
        int maxLine = Integer.MIN_VALUE;  // fix
        for (int i = 0; i < n - 1; i++) {
            minLine = Math.min(minLine, Math.max(nums[i], nums[i + 1]));  // fix
            maxLine = Math.max(maxLine, Math.min(nums[i], nums[i + 1]));  // fix
        }
        int diff = Math.max(0, (minLine - maxLine) * 2);
        for (int i = 1; i < n - 1; i++)
            diff = Math.max(diff, getAbsoluteDifference(nums[0], nums[i + 1]) - getAbsoluteDifference(nums[i], nums[i + 1]));

        for (int i = 0; i < n - 1; i++)
            diff = Math.max(diff, getAbsoluteDifference(nums[n - 1], nums[i]) - getAbsoluteDifference(nums[i + 1], nums[i]));
        return result + diff;
    }
}
```