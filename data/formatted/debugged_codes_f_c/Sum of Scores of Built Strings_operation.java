Bug Type: Logic Error / Incorrect Result

Reasoning: Upon first inspection, it is not immediately clear what the intention of the code is, as there are no comments or specific instructions provided. However, the bug can be identified by recognizing that the `getSubstrHash` method contains an incorrect operation.

The incorrect operation is `(h1 << 31) | h2`, which combines the two hash values. However, it's important to note that shifting (`<<`) by 31 is equivalent to multiplying by 2^31, which is not the intended operation. Here, it seems that the programmer intended to use the logical OR operator (`|`) to combine the two hash values.

To fix the bug, the line should be modified to `(h1 << 31) | h2` instead of `(h1 << 31) + h2`.

Fixed Code:
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
            if (s.charAt(i - 1) != s.charAt(0)) continue;
            int lo = 0, hi = n - i + 1, res = 0;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                if (getSubstr