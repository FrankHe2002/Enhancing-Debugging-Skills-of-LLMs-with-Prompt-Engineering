The bug in the provided code is that the inner loop runs up to `<= nums.length`, which will cause the index to go out of bounds. The correct condition should be `j < nums.length`.

To fix the bug, we need to modify the condition in the inner loop.

Here's the corrected code:
```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count = nums[j];
            }
        }
        return count;
    }
}
```