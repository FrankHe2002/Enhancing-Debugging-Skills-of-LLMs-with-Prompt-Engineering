Bug Type: Array Index Out of Bounds Exception

Reasoning Process:
- The code is using binary search to find the index of an element in the sorted array.
- However, there is a bug in the if condition inside the for loop.
- The condition `if (idx - 1 < 0 && sorted[idx - 1] == nums[i])` is checking if `idx - 1` is less than 0 and then accessing `sorted[idx - 1]`.
- The problem is that if `idx` is 0, then `idx - 1` will be -1 and accessing `sorted[-1]` will cause an ArrayIndexOutOfBoundsException.

Fix:
- Update the condition `if (idx - 1 < 0 && sorted[idx - 1] == nums[i])` to `if (idx <= 0 || sorted[idx - 1] != nums[i])`.
- This new condition checks if `idx` is less than or equal to 0 or if `sorted[idx - 1]` is not equal to `nums[i]`.
- If either of these conditions is true, it means that there are no duplicates of `nums[i]` before the current index `idx`.

Updated Code:

```java
// Runtime: 8 ms (Top 76.25%) | Memory: 44.5 MB (Top 55.91%)
import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        int[] res = new int[nums.length]; //result array
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; ++i) {
            //binary search it, if there is no duplicates the idx will be how many smaller are there
            int idx = binarySearch(sorted, nums[i]);
            //if there are duplicates, then we need to find the first one presented in the array
            if (idx <= 0 || sorted[idx - 1] != nums[i]) {
                while (idx >= 0 && sorted[idx] == nums[i]) {
                    --idx;
                }
                ++idx;
            }
            //As I said before, array of indices(indexes) will be the answer
            res[i] = idx;
        }
        return res;
    }

    //Just simple iterative binary search
    public static int binarySearch(int[] arr, int target) {
        int s = 