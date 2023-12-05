The bug type in the provided code is a logical error.

The logical error is in the `isGoodArray` method, where the condition to return true if the gcd equals 2 should be outside the loop, i.e. after calculating the gcd for all elements in the array. Also, the final return condition should be flipped, so that it returns true only if the gcd is equal to 1.

Additionally, the `GCD` method is correct and doesn't require any changes.

Fix:
```java
class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = GCD(gcd, nums[i]);
        }
        return gcd == 1;
    }

    int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
```