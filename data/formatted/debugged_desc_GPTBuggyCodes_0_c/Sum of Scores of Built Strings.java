Bug type: Logical Error

The logic for calculating the score of each string si seems incorrect. 

1. The initial calculation of hash and power arrays seems fine.
2. The loop for calculating the score within the sumScores method seems problematic.

Reasoning process to fix the bug:

- The main issue seems to be with the getSubstrHash method and its usage in the loop. The hash calculation and comparison logic might be incorrect. Also, the loop for calculating the score of each si needs to be re-evaluated.

Fix:
The getSubstrHash method should be refactored to return a single hash value based on the whole substring instead of two hash values like (h1 << 31) | h2.

Updated code:
```java
class Solution {
    public long[] hsh, pw;
    public int mod = (int) 1e9 + 7;

    public long sumScores(String s) {
        int n = s.length(), base = 131;
        hsh = new long[n + 1];
        pw = new long[n + 1];
        pw[0] = 1;

        for (int j = 1; j <= n; j++) {
            hsh[j] = (hsh[j - 1] * base + s.charAt(j - 1)) % mod;
            pw[j] = pw[j - 1] * base % mod;
        }
        
        long ans = n; // Start with the score of sn, which is n
        for (int i = 1; i < n; i++) {
            int lo = 0, hi = n - i, res = 0;
            while (lo < hi) {
                int length = lo + (hi - lo + 1) / 2;
                if (getSubstrHash(0, length, hsh, pw) == getSubstrHash(i, i + length, hsh, pw)) {
                    lo = length;
                    res = length;
                } else {
                    hi = length - 1;
                }
            }
            ans += res;
        }
        return ans;
    }

    public long getSubstrHash(int l, int r, long[] hsh, long[] pw) {
        return (hsh[r] - hsh[l] * pw[r - l] % mod + mod) % mod;
    }
}
```