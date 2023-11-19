```java
class Solution {
    public int minOperations(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int count = 0;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else if (num > nums[i]) {
                count += num - nums[i] + 1;
                num++;
            } else {
                num = nums[i];
            }
        }

        return count;
    }
}
```