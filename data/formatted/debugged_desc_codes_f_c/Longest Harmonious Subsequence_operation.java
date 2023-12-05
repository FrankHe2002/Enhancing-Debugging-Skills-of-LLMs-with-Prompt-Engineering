Explanation:

In the firstOccurence and lastOccurence methods, there are errors in the calculation of the mid index. The lastOccurence method uses division incorrectly, and the firstOccurrence method uses subtraction, which is not needed.

Additionally, there are some syntax errors, such as the space before the minus sign inside the methods.

The methods firstOccurrence and lastOccurrence should find the first and last occurrences of a target value in an array when using binary search. For the lastOccurrence method, the proper equation to calculate the mid index is (start + end) / 2, and the same should be used for the firstOccurrence method.

Fix:

```java
import java.util.*;

class Solution {
    public static int firstOccurence(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
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

    public static int lastOccurence(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
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
                int a = firstOccurence(nums, nums[i]);
                int b = lastOccurence(nums, nums[i] + 1);
                if (b - a + 1 > maxLen)
                    maxLen = b - a + 1;
            }
        }
        return maxLen;
    }
}
```