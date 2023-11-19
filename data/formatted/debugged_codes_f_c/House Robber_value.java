Bug Type: ArrayIndexOutOfBoundsException

Reasoning: The bug occurs in the for loop where `i` is initialized to `-1` and the loop condition is `i < t.length`. In Java, array indices start from 0, so when `i` is -1, it tries to access an index that is out of bounds, causing an `ArrayIndexOutOfBoundsException` error. 

Fix: Initialize `i` to 0 instead of -1 in the for loop.

Fixed Code:
```java
class Solution {
    public int rob(int[] nums) {
        int[] t = new int[nums.length];
        for (int i = 0; i < t.length; i++) {
            t[i] = - 1;
        }
        return helper(nums, 0, t);
    }

    static int helper(int[] nums, int i, int[] t) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[i];
        }
        if (t[i] != - 1) {
            return t[i];
        }

        int pick = nums[i] + helper(nums, i + 2, t);
        int unpicked = helper(nums, i + 1, t);
        t[i] = Math.max(pick, unpicked);
        return t[i];
    }
}
```