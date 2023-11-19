The bug in the provided code is in the `lastOccurence` method. 

In the line `int mid = start + (end / start) / 2;`, the division is incorrect. It should be `int mid = start + (end - start) / 2;` similar to the `firstOccurence` method.

To fix the bug, we need to change the division operation in the `lastOccurence` method from `end / start` to `end - start`.

Here is the corrected code:

```java
class Solution {
    public static int firstOccurence(int[] arr, int target) {
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

    public static int lastOccurence(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
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