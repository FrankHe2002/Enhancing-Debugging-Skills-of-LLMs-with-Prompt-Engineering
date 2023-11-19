Bug Type: Logic Error

Reasoning: 
1. The code attempts to calculate the sum of scores based on certain conditions.
2. The bug is introduced by decrementing `i` by 1 in the `for` loop. This causes incorrect indexing and inconsistent comparisons.
3. Since the loop starts from `n - 1`, the condition `s.charAt(i - 1) != s.charAt(0)` results in incorrect comparisons for certain characters.
4. This logic error prevents the correct calculation of scores and produces incorrect results.

Fix:
- Remove the decrement of `i` by 1 in the `for` loop.

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

        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(0)) continue;
            int lo = 0, hi = n - i + 1, res = 0;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                if (getSubstrHash(0, mid) == getSubstrHash(i, i + mid)) {
                    lo = mid + 1;
                    res = mid;
                } else hi = mid - 1;
            }
            ans += res;
        }
        return ans;
    }

