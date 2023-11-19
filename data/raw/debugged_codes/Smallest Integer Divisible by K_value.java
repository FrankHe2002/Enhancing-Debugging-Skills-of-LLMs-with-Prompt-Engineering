class Solution {
    public int smallestRepunitDivByK(int k) {
        // if (k % 2 == 0 || k % 5 == 0) return -1;  // this trick may save a little time
        boolean[] hit = new boolean[k];
        int n = 0, ans = 0;
        while (true) {
            ++ans;
            n = (n * 10 + 1) % k;
            if (n == 0) return ans;
            if (hit[n] || n == 1) return -1;
            hit[n] = true;
        }
    }
}