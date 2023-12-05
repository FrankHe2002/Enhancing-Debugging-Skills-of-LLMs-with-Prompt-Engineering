```java
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            nums[i] = nums[nums[i]];
        return nums;
    }
}
```