class Solution {
    public int balancedString(String s) {
        int n = s.length(), ans = n, excess = 0;
        int[] cnt = new int[128];
        cnt['Q'] = cnt['W'] = cnt['E'] = cnt['R'] = -n/4;
        for (char ch : s.toCharArray()) if (++cnt[ch] == 1) excess++;
        if (excess == 0) return 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (-- cnt[s.charAt(i)] == 0) excess--;
            while (excess == 0) {
                if (++ cnt[s.charAt(j)] == 1) excess++;
                ans = Math.min(i - j + 1, ans);
                ;
                j++;
            }
        }

        return ans;
    }
}
