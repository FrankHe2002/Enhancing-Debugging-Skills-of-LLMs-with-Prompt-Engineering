class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int N = nums.length;
        List<Integer> res = new ArrayList<>();

        int[] pref = new int[N + 1];
        pref[0] = 0;
        for (int i = 1; i <= N; ++ i) pref[i] = nums[i - 1] + pref[i - 1];

        int maxScore = - 1;
        int onesToRight, zeroesToLeft, currScore;

        for (int i = 0; i <= N; ++ i) {
            onesToRight = pref[N] - pref[i];
            zeroesToLeft = i - pref[i];
            currScore = zeroesToLeft + onesToRight;

            if (currScore > maxScore) {
                res.clear();
                maxScore = currScore;
            }
            if (currScore == maxScore) res.add(i);
        }
        return res;
    }
}