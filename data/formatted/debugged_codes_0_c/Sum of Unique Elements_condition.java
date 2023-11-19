There is a bug in the given Java code.

The bug is in the for loop condition: `i <= nums.length`. 

The index in the loop should only go up to `nums.length - 1`, because array indices start from 0 and go up to `length - 1`. 

To fix the bug, we need to change the condition to `i < nums.length`.

Here's the corrected code:

```java
class Solution {
    public int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1) res += nums[i];
            else if (map.get(nums[i]) == 2) res -= nums[i];
        }
        return res;
    }
}
```