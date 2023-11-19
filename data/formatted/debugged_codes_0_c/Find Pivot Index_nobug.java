The bug in this code is that the `leftsum` is not properly initialized or updated. It is always 0 throughout the code execution, so the first `if` condition `if (leftsum == rightsum)` will always be true and the method will always return 0.

To fix this bug, we need to initialize `leftsum` correctly by summing all the elements before the current index. The for loop should start from 0 instead of 1 in order to include the first element of the array.

Here's the fixed code:

```java
class Solution {
    public int pivotIndex(int[] nums) {

        int rightsum = 0;
        for (int i = 1; i < nums.length; i++) rightsum += nums[i];

        int leftsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == rightsum) return i;
            leftsum += nums[i];
            rightsum -= nums[i + 1];
        }
        return -1;
    }
}
```