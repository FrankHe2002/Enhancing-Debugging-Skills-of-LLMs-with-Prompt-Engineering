class Solution {
    public int makeArrayIncreasing(int[] A, int[] B) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.stream(B).boxed().toList());
        int[] dp = new int[B.length + 1];
        dp[0] = - 1;
        int INF = (int) 2e9;
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length; j >= 0; j--) {
                int a = A[i] > dp[j] ? A[i] : INF;
                Integer b = set.higher(j == 0 ? INF : dp[j - 1]);
                dp[j] = Math.min(a, b == null ? INF : b);
            }
        }
        for (int i = 0; i <= B.length; i++)
            if (dp[i] != INF) {
                return i;
            }
        return - 1;
    }
}