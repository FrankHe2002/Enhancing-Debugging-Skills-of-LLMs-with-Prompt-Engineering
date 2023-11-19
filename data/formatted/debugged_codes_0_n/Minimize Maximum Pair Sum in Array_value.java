```java
// Runtime: 89 ms (Top 12.88%) | Memory: 106.2 MB (Top 41.39%)
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int output = Integer.MIN_VALUE;

        for (int i = 0, j = nums.length - 1; i < nums.length / 2; i++, j--) {
            output = Math.max(output, nums[i] + nums[j]);
        }

        return output;
    }
}
```