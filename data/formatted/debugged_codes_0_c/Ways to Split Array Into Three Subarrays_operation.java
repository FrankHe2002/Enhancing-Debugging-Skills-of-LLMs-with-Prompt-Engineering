Bug Type: Off-by-one error

Reasoning: 
- The code iterates over the array `nums` from 0 to `size - 2` (inclusive) in the outer for loop.
- Inside the loop, it calls `searchLeft` and `searchRight` methods, passing the index `size - 1` as the `right` parameter.
- The `searchLeft` and `searchRight` methods use the `right` parameter to determine the range of elements to search in the `nums` array. The range is defined as `[left + 1, right - 1]`.
- Since `right` is passed as `size - 1` in the loop, the range becomes `[left + 1, size - 1 - 1] = [left + 1, size - 2]`.
- However, the loop only iterates until `size - 2`, so the last element of the range `[left + 1, size - 2]` is not included in the search range. This means that the last element is not considered when searching for the left and right splits.

Fix:
- To fix the off-by-one error, change the loop condition in the outer for loop to `i < size - 1`.

Updated code:

```java
class Solution {
    public int waysToSplit(int[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; ++ i) {
            nums[i] += nums[i - 1];
        }
        int res = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < size - 1; ++ i) { // Fix: change loop condition to i < size - 1
            int left = searchLeft(nums, i, size - 1);
            int right = searchRight(nums, i, size - 1);
            if (left == - 1 || right == - 1) {
                continue;
            }
            res = (res + right - left + 1) % mod;
        }
        return res;
    }

    private int searchLeft(int[] nums, int left, int right) {
        int pos = - 1;
        int min = nums[left];
        int lo = left + 1, hi = right - 1;
        while (lo <= hi) {
            int mi = lo - (hi