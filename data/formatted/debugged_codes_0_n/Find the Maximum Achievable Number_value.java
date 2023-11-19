class Solution {
    public int numTimesAllBlue(int[] light) {
        int n = light.length;
        int[] right = new int[n + 1];
        int max = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, light[i]);
            if (max == i + 1) {
                ans++;
            }
        }

        return ans;
    }
}