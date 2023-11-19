class Solution {
    int changeTime;

    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        this.changeTime = changeTime;
        int[] minTime = new int[numLaps + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        for (int[] tire : tires) {
            populateMinTime(tire, minTime);
        }

        int[] dp = new int[numLaps + 1];
        for (int i = 1; i <= numLaps; i++) {
            dp[i] = minTime[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + changeTime + dp[i - j]);
            }
        }
        return dp[numLaps];
    }

    private void populateMinTime(int[] tire, int[] minTime) {
        int sum = 0;
        int base = tire[0];
        int ex = tire[1];
        int spent = 1;
        for (int i = 1; i < minTime.length; i++) {
            spent = (i == 1) ? base : spent * ex;
            if (spent > changeTime + base) {
                break;
            }
            sum += spent;
            minTime[i] = Math.min(minTime[i], sum);
        }
    }
}