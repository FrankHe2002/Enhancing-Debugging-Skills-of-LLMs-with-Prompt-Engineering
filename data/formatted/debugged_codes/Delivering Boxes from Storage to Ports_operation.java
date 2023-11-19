class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int[] diffCity = new int[boxes.length + 1];
        int[] weights = new int[boxes.length + 1];

        for (int i = 0; i < boxes.length; i++) {
            diffCity[i + 1] = diffCity[i] + ((i != 0 && boxes[i][0] == boxes[i - 1][0]) ? 0 : 1);
            weights[i + 1] = weights[i] + boxes[i][1];
        }
        int[] dp = new int[boxes.length + 1];
        int[] origin = new int[boxes.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        diffCity[0] = 1;
        for (int i = 1; i <= boxes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int dC = diffCity[i] - diffCity[j + 1];
                int w = weights[i] - weights[j];
                int b = i - j;
                if (b <= maxBoxes && w <= maxWeight) {
                    if (dp[j] + dC < dp[i]) {
                        dp[i] = dp[j] + dC;
                        origin[i] = j;
                    }
                }
            }
        }
        int result = 0;
        for (int i = boxes.length; i != 0; ) {
            result++;
            i = origin[i];
        }
        return result;
    }
}