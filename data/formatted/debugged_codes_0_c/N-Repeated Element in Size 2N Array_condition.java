The bug in the provided code is that the inner loop is going one index past the end of the nums array. This will result in an IndexOutOfBoundsException when trying to access nums[j] if j equals nums.length. 

To fix this bug, we need to change the condition in the inner loop from `j <= nums.length` to `j < nums.length`.

Here is the fixed code:

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

By making this change, the inner loop will iterate from i + 1 to nums.length - 1, ensuring that we don't go out of bounds of the nums array.