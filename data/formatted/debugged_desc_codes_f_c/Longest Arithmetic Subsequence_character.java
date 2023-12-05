Error:
1. The variable `dp` is a map of arrays. However, the map is declared with the `>` symbol after `Integer`, instead of after `Map` and uses `]` instead of `]`. Also, the line `Map<Integer, Integer>] dp = new HashMap[n];` will cause a compile error and doesn't correctly represent the intention of creating a 2D map.
2. The loop condition in the inner for loop should be `j < i` instead of `j < n`.

Fix:
```java
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int longest = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];

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