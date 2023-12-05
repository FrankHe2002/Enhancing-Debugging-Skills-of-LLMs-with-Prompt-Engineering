The bug in the provided code is in the for loop where the variable `i` is incorrectly iterating from 0 to `<= nums.length`. It should iterate from 0 to `< nums.length` as arrays are 0-indexed.

Additionally, the loop should be decrementing the value of `res` if a number appears more than once, which is not handled correctly in the current implementation.

Here's the fixed code:

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1) {
                res += nums[i];
            } else if (map.get(nums[i]) == 2) {
                res -= nums[i];
            }
        }
        return res;
    }
}
```

The fix involves changing the loop termination condition from `<= nums.length` to `< nums.length` and adding curly braces to properly enclose the if-else statements.