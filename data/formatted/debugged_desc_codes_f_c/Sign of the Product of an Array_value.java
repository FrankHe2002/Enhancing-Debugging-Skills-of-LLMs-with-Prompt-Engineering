The bug in the given Java code is in the `signFunc` method. The condition used for checking if `x` is positive is incorrect. It should be `x > 0` instead of `x > 1`. Additionally, the condition for returning -1 is incorrect, it should be else if (x < 0), not else if (x < 0).

The following is the fixed code:

```java
class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            int val = signFunc(nums[i]);
            prod *= val;
        }
        return sign(prod);
    }

    private int signFunc(int x) {
        if (x < 0) {
            return -1;
        } else if (x > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
```