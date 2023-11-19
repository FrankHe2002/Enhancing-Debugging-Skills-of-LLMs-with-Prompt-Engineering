class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            for (int j = 0; j < n; j++) {
                int left = i - j;
                int right = i + j;
                if (left < 0 || right >= n) break;
                if (s.charAt(left) != s.charAt(right)) break;

                if (right - left + 1 >= k) {
                    dp[right + 1] = Math.max(dp[right + 1], dp[left] + 1);
                }

            }
            for (int j = 0; j < n; j++) {
                int left = i - j - 1;
                int right = i + j;
                if (left < 0 || right >= n) break;
                if (s.charAt(left) != s.charAt(right)) break;

                if (right - left + 1 >= k) {
                    dp[right + 1] = Math.max(dp[right + 1], dp[left] + 1);
                }
            }
        }
        return dp[n];
    }
}