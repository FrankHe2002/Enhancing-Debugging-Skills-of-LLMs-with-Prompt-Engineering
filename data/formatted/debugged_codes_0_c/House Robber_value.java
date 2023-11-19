The bug in the provided code is on line 6. 

The for loop is initialized with `i = -1`, and it should be `i = 0` instead. 

This is because the array `t` is meant to store the results of subproblems, and array indices start at 0 in Java. By initializing `i` to -1, the code is essentially trying to access index -1 of the array `t`, which is out of bounds and causes an ArrayIndexOutOfBoundsException.

To fix the bug, we need to change the initialization of `i` in the for loop from -1 to 0:

```java
for (int i = 0; i < t.length; i++) {
    t[i] = -1;
}
```

Here's the fixed code:

```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.8 MB (Top 31.47%)
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

This fix ensures that the array `t` is properly initialized, and the bug causing the ArrayIndexOutOfBoundsException is resolved.