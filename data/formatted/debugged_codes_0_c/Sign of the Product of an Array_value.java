The bug in the provided Java code is in the signFunc method. The if statement should check if x is greater than 0, not greater than 1. The current implementation only returns 1 for any positive value of x, which is incorrect.

To fix the bug, the if statement in the signFunc method should be updated to:

```java
if (x < 0) return - 1;
else if (x > 0) return 1;
```

Here's the corrected code:

```java
class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            int val = signFunc(nums[i]);
            prod *= val;
        }
        return prod;
    }

    private int signFunc(int x) {
        if (x < 0) return - 1;
        else if (x > 0) return 1;
        return 0;
    }
}
```