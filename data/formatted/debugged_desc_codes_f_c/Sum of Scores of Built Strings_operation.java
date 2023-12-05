Fix:
```java
class Solution {
    public long[] hsh, hsh2, pw, pw2;
    public int mod = (int) 1e9 + 7;

    public long sumScores(String s) {
        int n = s.length(), base = 131, base2 = 137;
        hsh = new long[n + 1];
        pw = new long[n + 1];
        hsh2 = new long[n + 1];
        pw2 = new long[n + 1];
        pw[0] = 1;
        pw2[0] = 1;
        for (int j = 1; j <= n; j++) {
            hsh[j] = (hsh[j - 1] * base + s.charAt(j - 1)) % mod;
            pw[j] = pw[j - 1] * base % mod;
            hsh2[j] = (hsh2[j - 1] * base2 + s.charAt(j - 1)) % mod;
            pw2[j] = pw2[j - 1] * base2 % mod;
        }
        // binary search for score
        long ans = 0;
        for (int i = n; i >= 1; i--) {
            int lo = 0, hi = i - 1, res = 0;
            while (lo <= hi) {
                int mid = (lo + hi + 1) / 2;
                if (getSubstrHash(0, mid - 1) == getSubstrHash(n - i, n - i + mid - 1)) {
                    lo = mid;
                    res = mid;
                } else hi = mid - 1;
            }
            ans += res;
        }
        return ans;
    }

    public long getSubstrHash(int l, int r) {
        long h1 = (hsh[r + 1] - hsh[l] * pw[r - l + 1] % mod + mod) % mod;
        long h2 = (hsh2[r + 1] - hsh2[l] * pw2[r - l + 1] % mod + mod) % mod;
        return (h1 << 31) | h2;
    }
}
```