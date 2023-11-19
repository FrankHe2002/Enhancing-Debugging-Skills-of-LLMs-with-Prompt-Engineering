```java
class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = GCD(gcd, nums[i]);
            if (gcd == 1)
                return true;
        }
        return gcd == 1;
    }

    int GCD(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return GCD(b, a % b);
        }
    }
}
```