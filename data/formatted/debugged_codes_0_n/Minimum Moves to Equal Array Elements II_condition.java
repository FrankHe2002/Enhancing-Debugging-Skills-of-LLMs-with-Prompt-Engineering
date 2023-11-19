```java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int idx = (nums.length - 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) { // Changed i <= nums.length to i < nums.length
            sum += Math.abs(nums[i] - nums[idx]);
        }
        return sum;
    }
}
```