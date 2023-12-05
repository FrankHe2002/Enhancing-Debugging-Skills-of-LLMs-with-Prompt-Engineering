Issues:
1. There are syntax errors in the functions `firstOccurrence` and `lastOccurrence`. It should be `Occurrence` instead of `Occurence`.
2. There is a logical error in the `lastOccurrence` function where `mid` is mistakenly subtracted instead of adding in the second while loop.

The fixing process:

```java
import java.util.Arrays;

class Solution {
    public static int firstOccurrence(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // corrected this from "int mid = start + (end / start) / 2;"
            if (arr[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
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
                int a = firstOccurrence(nums, nums[i]); // corrected this from "int a = firstOccurence(nums, nums[i]);"
                int b = lastOccurrence(nums, nums[i] + 1); // corrected this from "int b = lastOccurence(nums, nums[i] + 1);"
                if (b - a + 1 > maxLen)
                    maxLen = b - a + 1;
            }
        }
        return maxLen;
    }
}
```