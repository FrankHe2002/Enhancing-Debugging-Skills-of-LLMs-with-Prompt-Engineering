Bug Type: Off-by-one error

Explanation:
1. The code calculates the hash values for substrings of the given string `s` using two different bases (`base` and `base2`).
2. The code then iterates from the second character (`i = n - 1`) to the second-to-last character (`i >= 1`) of the string `s`.
3. For each character at position `i`, the code checks if it is equal to the first character (`s.charAt(0)`).
4. If the characters are equal, the code performs a binary search to find the length of the longest common prefix between the substring starting at position 0 and the substring starting at position `i - 1`.
5. The code adds the length of the longest common prefix to the `ans` variable.
6. Finally, the code returns the value of `ans`.

Bug:
The bug occurs in the for loop where `i` is initialized to `n - 1`. It is later used as the starting position for the substrings in the `getSubstrHash` method. However, the index `i - 1` is used as the starting position for the substring, which is incorrect.

Fix:
To fix the bug, we need to increment `i` by 1, changing the loop from `for (int i = n - 1; i >= 1; i--)` to `for (int i = n - 1; i >= 0; i--)`. This change ensures that the correct starting position is used for the substrings.

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
        for (int j = 1; j <= n; j++) {
            hsh[j] = (hsh[j - 1] * base + s.charAt(j - 1)) % mod;
            pw[j] = pw[j - 1] * base