Bug type: Off-by-one Error

Explanation: 
1. The code is calculating the hash values and storing them in the `hsh` and `hsh2` arrays.
2. `hsh[i]` represents the hash value of the substring from index 0 to i.
3. `hsh2[i]` represents the hash value of the substring from index 0 to i (using a different base).
4. However, there is an off-by-one error in the calculation of the hash values.
5. The loop in line 12 is iterating from 1 to n (inclusive), but it should iterate from 0 to n-1.
6. This causes incorrect calculation of the hash values and consequently the incorrect comparison in the binary search.

Fix:
Change line 12 from `for (int j = 1; j <= n; j++)` to `for (int j = 0; j < n; j++)`. This will iterate from 0 to n-1 and correctly calculate the hash values.

Updated code:

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
        for (int j = 0; j < n; j++) {
            hsh[j] = (hsh[j - 1] * base + s.charAt(j)) % mod;
            pw[j] = pw[j - 1] * base % mod;
            hsh2[j] = (hsh2[j - 1] * base2 + s.charAt(j)) % mod;
            pw2[j] = pw2[j - 1] * base2 % mod;
        }
        // binary search for score
        long ans = 0;
        for (int i = n; i >= 1; i--) {
            if (s.charAt(i - 1) != s.charAt(0)) continue;
            int lo = 0, hi = n - i + 1,