Bug type: Logical error

Reasoning:
The code is attempting to find the maximum value of (nums[i]-1)*(nums[j]-1) by finding the two maximum values in the array and then performing the calculation. 

Potential issues:
1. The code does not handle cases where there are duplicate maximum values which will result in the same index being used for both i and j.
2. The calculation of (max * nextmax - max - nextmax + 1) is incorrect for finding the maximum value of (nums[i]-1)*(nums[j]-1).

Fix:
To fix the logical error, we can sort the array in descending order and then calculate the product of the first two elements in the sorted array after subtracting 1 from each element.

Updated code:
```java
import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1] - 1) * (nums[n-2] - 1);
    }
}
```