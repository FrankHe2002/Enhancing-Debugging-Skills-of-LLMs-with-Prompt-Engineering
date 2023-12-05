```java
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        int[] prefixSums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
            prefixSums[i] = sum;
        }
        Integer[][] dp = new Integer[n][n];
        return merge(0, n - 1, stones, k, dp, prefixSums);
    }

    private int merge(int start, int end, int[] stones, int k, Integer[][] dp, int[] prefixSums) {
        if (dp[start][end] != null) {
            // already computed
            return dp[start][end];
        }
        if (start == end) {
            // base case: single pile already
            dp[start][end] = 0;
            return 0;
        }
        if ((end - start) % (k - 1) != 0) {
            // end - start + 1 is how many piles to merge
            // so end - start is how many piles we have to delete by merge
            // and at each merge, we delete k-1 piles.
            dp[start][end] = -1;
            return -1;
        }
        // ok so now have K or more piles to merge
        // need to test all possible K-partitions using K-1 delimiters and recurse on them and min.
        int minCost = Integer.MAX_VALUE;
        for (int i = start; i < end; i += k - 1) {
            int left = merge(start, i, stones, k, dp, prefixSums);
            int right = merge(i + 1, end, stones, k, dp, prefixSums);
            if (left != -1 && right != -1) {
                minCost = Math.min(minCost, left + right);
            }
        }
        dp[start][end] = (minCost == Integer.MAX_VALUE) ? -1 : minCost + prefixSums[end] - (start == 0 ? 0 : prefixSums[start - 1]);
        return dp[start][end];
    }
}
```