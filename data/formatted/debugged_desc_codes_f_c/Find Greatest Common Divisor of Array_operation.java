The bug type is a logical error.

The bug in the original code using the `findGCD` function is that the condition in the while loop to calculate the GCD is incorrect. In the expression `n / result == 0`, the intention is to check if the remainder is 0 when `n` is divided by `result`. However, the comparison should be for a remainder of 0, not for `0`.

Here's the fixed version of the code. I corrected the logical error in the while loop condition:
```java
import java.util.Arrays;

class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums[nums.length - 1];
        int result = nums[0];
        while (result > 0) {
            if (nums[0] % result == 0 && n % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }
}
```