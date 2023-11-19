Bug Type: Index Out of Bounds

Reasoning: The buggy code attempts to access the element at `sorted[idx - 1]` without checking if `idx - 1` is a valid index. This can result in an `ArrayIndexOutOfBoundsException` if `idx - 1` is less than 0. 

Fix: 
- In the `if` condition, check if `idx > 0` instead of `idx - 1 < 0`. This ensures that `idx - 1` is a valid index before accessing the element `sorted[idx - 1]`. 
- Update the `while` loop condition to `while (idx >= 0 && sorted[idx] == nums[i])` to prevent accessing elements outside the valid range.
- Increment `idx` after finding the first occurrence of the target element in the array.

Fixed Code:
```java
import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        int[] res = new int[nums.length];
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; ++i) {
            int idx = binarySearch(sorted, nums[i]);
            if (idx > 0 && sorted[idx - 1] == nums[i]) {
                while (idx >= 0 && sorted[idx] == nums[i]) {
                    --idx;
                }
                ++idx;
            }
            res[i] = idx;
        }
        return res;
    }

    public static int binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int m = (s + e) / 2;

        while (s <= e) {
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
            m = (s + e) / 2;
        }
        return -1;
    }
}
```