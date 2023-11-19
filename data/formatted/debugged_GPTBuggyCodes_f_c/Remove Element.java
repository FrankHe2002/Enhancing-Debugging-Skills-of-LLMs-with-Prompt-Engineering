The bug in the provided code is in the loop condition `i <= nums.length`. This causes an `ArrayIndexOutOfBoundsException` because the loop attempts to access an index out of the array's bounds.

To fix this bug, we need to change the loop condition to `i < nums.length` to ensure the loop iterates only within the valid range of the array indices.

Here is the code with the bug fixed:
```java
// Runtime: 0 ms (Top 100.00%) | Memory: 42.4 MB (Top 71.77%)

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