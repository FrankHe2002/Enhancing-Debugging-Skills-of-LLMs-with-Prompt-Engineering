After reviewing the provided Java code, the bug in the given code is in the `firstOccurrence` and `lastOccurence` methods. The binary search algorithm implementation provided in these methods is incorrect. The bug exists in the `res` initialization, and the comparisons to adjust `start` and `end`.

To fix the bug, we can update the binary search algorithm inside the methods to find the first and last occurrences of the target in the array `arr`.

Here's the updated code with the bug fix:

```java
import java.util.Arrays;

class Solution {
    public static int firstOccurrence(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                res = arr[mid] == target ? mid : res;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                res = arr[mid] == target ? mid : res;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
    
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxLen = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                int a = firstOccurrence(nums, nums[i]);
                int b = lastOccurrence(nums, nums[i]);
                if (b - a + 1 > maxLen) {
                    maxLen = b - a + 1;
                }
            }
        }
        return maxLen;
    }
}
```

In this fixed code:
- Updated the `firstOccurrence` and `lastOccurrence` methods by correcting the handling of `res` and comparisons in the binary search algorithm.
- The `Binary Search` logic was updated to match the new code.
- Compared the output with the input parameters and returned the result accordingly.