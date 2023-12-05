The bug in the provided code is in the while loop condition. Currently, it says `while (a >= nums.length)`, which means the loop will not run because a is initialized to 0 and `0 >= nums.length` is false.

To fix this bug, the condition should be `while (a < nums.length)`, so that the loop runs for each element of the array.

Here's the corrected code:

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int a = 0, z = 0, temp;
        while (a < nums.length) {
            if (nums[a] != 0) {
                temp = nums[z];
                nums[z] = nums[a];
                nums[a] = temp;
                z += 1;
            }
            a += 1;
        }
    }
}
```