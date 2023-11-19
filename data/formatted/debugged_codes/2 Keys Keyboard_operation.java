class Solution {
    public int minSteps(int n) {
        int rem = n - 1;
        int copied = 0;
        int ans = 0;
        int onScreen = 1;

        while (rem > 0) {
            if (rem + onScreen == 0) {
                ans++;
                copied = onScreen;
            }
            rem -= copied;
            ans++;
            onScreen = n - rem;
        }

        return ans;
    }
}