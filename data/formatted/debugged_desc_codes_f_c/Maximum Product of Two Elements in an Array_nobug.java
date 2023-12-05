The bug in the provided Java code is that the formula to calculate the maximum product of two elements `(nums[i]-1)*(nums[j]-1)` is incorrect. The code currently uses `return max * nextmax - max - nextmax + 1`, but the correct formula should be `return (max - 1) * (nextmax - 1)` to find the maximum product of two elements from the array.

Fix:
```java
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxi = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
        }
        nums[maxi] = Integer.MIN_VALUE;
        int nextmax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nextmax) nextmax = nums[i];
        }
        return (max - 1) * (nextmax - 1);
    }
}
```