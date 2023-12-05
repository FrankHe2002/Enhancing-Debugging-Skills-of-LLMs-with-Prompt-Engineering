The code seems to have a bug in the binarySearch method. The starting index for the binary search should be 0, and the ending index should be arr.length - 1.

Here's the corrected code:

```java
// Runtime: 8 ms (Top 76.25%) | Memory: 44.5 MB (Top 55.91%)
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        int[] res = new int[nums.length]; // result array
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; ++i) {
            // binary search it to find the count of smaller numbers
            int idx = binarySearch(sorted, nums[i]);
            res[i] = idx;
        }
        return res;
    }

    // Iterative binary search with proper start and end indices
    public static int binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr[m] == target) {
                // count smaller numbers
                int count = 0;
                for (int i = 0; i < m; i++) {
                    if (arr[i] < target) {
                        count++;
                    }
                }
                return count;
            } else if (arr[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}
```