Bug Type: Off-by-One Error

Explanation:

In the initial loop condition, `(int i = 0; i < (1 << (n / 2)); ++ i)`, the loop is iterating up to `(1 << (n / 2))`, which is correct. However, in the nested loop condition, `(int j = 0; j < n + 2; ++ j)`, the loop is iterating up to `n + 2`, which is incorrect. It should be `n / 2 + 2` to align with the logic of the algorithm.

Fix:

Change the nested loop condition from `(int j = 0; j < n + 2; ++ j)` to `(int j = 0; j < n / 2 + 2; ++ j)`.

Fixed Code:

```java
// Runtime: 893 ms (Top 61.90%) | Memory: 51.3 MB (Top 87.91%)
class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        TreeSet<Integer>[] sets = new TreeSet[n / 2 + 1];
        for (int i = 0; i < (1 << (n / 2)); ++ i) {
            int curSum = 0;
            int m = 0;
            for (int j = 0; j < n / 2; ++ j) {
                if ((i & (1 << j)) != 0) {
                    curSum += nums[j];
                    m++;
                }
            }
            if (sets[m] == null)
                sets[m] = new TreeSet<Integer>();
            sets[m].add(curSum);
        }

        int res = Integer.MAX_VALUE / 3;
        for (int i = 0; i < (1 << (n / 2)); ++ i) {
            int curSum = 0;
            int m = 0;
            for (int j = 0; j < n / 2 + 2; ++ j) { // Fix: change n + 2 to n / 2 + 2
                if ((i & (1 << j)) != 0) {
                    curSum += nums[n / 2 + j];
                    m++;
                }
            }
            int target = (sum - 2 *