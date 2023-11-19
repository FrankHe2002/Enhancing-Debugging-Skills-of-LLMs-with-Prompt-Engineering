class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j < currentRow.size(); j++) {
                dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}