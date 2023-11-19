Bug type: Logic error and missing semicolon

Reasoning:
1. In the first loop, the variable `indx` is calculated correctly to determine the index in `nums`. However, the condition `nums[indx] < 0` is incorrect. It should check if `nums[indx]` is greater than 0 to indicate that the number is missing. The correct condition should be `nums[indx] > 0`.
2. In the second loop, there is a missing semicolon at the end of the statement `nums[i] *= -1`. Adding a semicolon at the end fixes this syntax error.

Fixed code:

```java
// Runtime: 9 ms (Top 62.33%) | Memory: 67.5 MB (Top 39.21%)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 0 1 2 3 4 5 6 7 <- indx
        // 4 3 2 7 8 2 3 1 <- nums[i]
        for (int i = 0; i < nums.length; i++) {
            int indx = Math.abs(nums[i]) - 1;
            if (nums[indx] > 0) {
                nums[indx] = nums[indx] * -1;
            }
        }
        // 0 1 2 3 4 5 6 7 <- indx
        // -4 -3 -2 -7 8 2 -3 -1 <- nums[i]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        // [ 5, 6]
        return res;
    }
}
```