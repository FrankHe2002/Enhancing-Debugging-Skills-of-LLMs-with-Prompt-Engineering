```java
class Solution {
    public boolean checkPossibility(int[] nums) {
        int modified = 0;
        int prev = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] < prev) {
                if (++modified > 1) return false;
                if (index - 2 >= 0 && nums[index - 2] > nums[index]) {
                    prev = nums[index - 1];
                } else {
                    prev = nums[index];
                }
            } else {
                prev = nums[index];
            }
        }
        return true;
    }
}
```