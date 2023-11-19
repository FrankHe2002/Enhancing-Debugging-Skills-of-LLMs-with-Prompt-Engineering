// Runtime: 3 ms (Top 99.46%) | Memory: 47.4 MB (Top 86.67%)
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        Deque<Integer> deque = new ArrayDeque<>(); // Declaring deque

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        deque.offer(0);

        for (int j = 1; j < n; j++) {
            int i = Math.max(j - k, 0); // get the furthest index possible
            while (!deque.isEmpty() && deque.peekFirst() < i) deque.pollFirst(); // find the global max in the specified range for that particular j index
            int idx = deque.peekFirst();
            dp[j] = Math.max(dp[idx] + nums[j], nums[j]);
            res = Math.max(res, dp[j]);
            while (!deque.isEmpty() && dp[j] >= dp[deque.peekLast()]) deque.pollLast(); // update the deque to maintain the decreasing order
            deque.offerLast(j);
        }
        return res;
    }
}