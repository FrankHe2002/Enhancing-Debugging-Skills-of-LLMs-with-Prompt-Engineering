The bug in the given code is in the condition `if (nums[0] % result == 0 && n / result == 0)` inside the while loop. It should be `if (nums[0] % result == 0 && n % result == 0)` instead of `if (nums[0] % result == 0 && n / result == 0)`.

Here's the fixed code:

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