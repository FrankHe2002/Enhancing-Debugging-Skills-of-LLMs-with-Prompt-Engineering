class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int N = dist.length, INF = (int) 1e9;
        int[] dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j] = Math.min((j == 0 ? INF : dp[j - 1] + dist[i]), ceil(dp[j], speed) + dist[i]);
            }
        }
        for (int i = 0; i < N; i++) {
            if (ceil(dp[i], speed) / speed <= hoursBefore) {
                return i;
            }
        }
        return - 1;
    }

    private int ceil(int n, int s) {
        return n + (s - n % s - 1) / s;
    }
}