Bug: IndexOutOfBounds Error

Reasoning:
1. The variable `total` is incorrectly calculated by looping through the array nums.
2. The loop in line 6 tries to iterate the `total` 2 positions ahead each time, resulting in an IndexOutOfBoundsException due to the out-of-bound access in the last iteration.

Implementing Fix:
1. Update the element access in the `total` calculation to `nums[i]`.
2. Considering the constraints, change the loop condition to `i < Math.min(nums.length, 3)` to avoid the IndexOutOfBoundsException.

Fixed code:
```java
// Runtime: 7 ms (Top 34.08%) | Memory: 44.9 MB (Top 74.04%)
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int total = 0;
        for (int i = 0; i < Math.min(nums.length, 3); i++) {
            total += nums[i];
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            sum += nums[i];
            if (sum > total - sum) {
                return ans;
            }
        }
        return ans;
    }
}
```