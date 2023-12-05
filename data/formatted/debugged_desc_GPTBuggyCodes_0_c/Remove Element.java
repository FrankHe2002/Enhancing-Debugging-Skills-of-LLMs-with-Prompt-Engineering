The buggy line is `for (int i = 0; i <= nums.length; i++)`.

The logic to remove all occurrences of `val` from the `nums` array is correct. However, the bug is in the for loop's condition. The condition should be `i < nums.length` instead of `i <= nums.length`. It's causing an ArrayIndexOutOfBoundsException since the loop is iterating beyond the length of the array `nums`.

Here's the fixed code with the minimal change:

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ind++] = nums[i];
            }
        }
        return ind;
    }
}
```