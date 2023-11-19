```java
// Runtime: 4 ms (Top 100%) | Memory: 42.5 MB (Top 79%)

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int longest = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                longest = Math.max(longest, dp[i].get(diff));
            }
        }

        return longest;
    }
}
```