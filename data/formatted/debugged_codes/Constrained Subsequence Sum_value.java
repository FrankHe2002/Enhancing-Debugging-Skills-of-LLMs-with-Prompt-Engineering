class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        deque.offer(0);

        for (int j = 1; j < n; j++) {
            int i = Math.max(j - k, 0);
            while (! deque.isEmpty() && deque.peekFirst() < i)
                deque.pollFirst();
            int idx = deque.peekFirst();
            dp[j] = Math.max(dp[idx] + nums[j], nums[j]);
            res = Math.max(res, dp[j]);
            while (! deque.isEmpty() && dp[j] >= dp[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(j);
        }
        return res;
    }
}