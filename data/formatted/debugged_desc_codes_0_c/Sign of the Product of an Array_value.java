The bug in the provided code is in the `signFunc` method. The condition `else if (x > 1)` should be `else if (x > 0)`.

Here is the fixed code:

```java
class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            int val = signFunc(nums[i]);
            prod *= val;
        }
        return signFunc(prod);
    }

    private int signFunc(int x) {
        if (x < 0) return -1;
        else if (x > 0) return 1;
        return 0;
    }
}
```