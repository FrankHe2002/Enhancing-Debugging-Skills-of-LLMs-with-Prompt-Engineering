```java
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int modified = 0, prev = nums[0], index = 0;
        for (; index < nums.length; ++index) {
            if (nums[index] < prev) {
                if (++modified > 1) return false;
                if (index - 1 >= 0 && nums[index - 1] > nums[index + 1])  nums[index] = nums[index - 1];
            }
            prev = nums[index];
        }
        return true;
    }
}
```