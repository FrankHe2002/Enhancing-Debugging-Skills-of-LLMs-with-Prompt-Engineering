```java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int idx = nums.length / 2; // fix: removed the subtraction
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - nums[idx]);
        }
        return sum;
    }
}
```