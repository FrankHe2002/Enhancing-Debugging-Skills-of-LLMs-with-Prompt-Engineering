```java
class Solution {
    public int countHillValley(int[] nums) {
        int result = 0;
        int start = 1;
        while (start < nums.length && nums[start] == nums[start - 1])
            start++;

        int prev = start;
        for (int i = start; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                continue;
            else {
                if (nums[i] > nums[prev] && nums[i] > nums[i + 1])
                    result++;
                if (nums[i] < nums[prev] && nums[i] < nums[i + 1])
                    result++;
                prev = i;
            }
        }

        return result;
    }
}
```