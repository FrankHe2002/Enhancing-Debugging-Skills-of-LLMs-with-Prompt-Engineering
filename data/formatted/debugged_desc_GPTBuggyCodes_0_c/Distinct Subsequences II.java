Bug:
The bug in the code is a logical error in the for loop where the index for the `li[]` array is being set incorrectly.

Fix:
The index for the `li[]` array should be set to `idx` instead of `i`.

Reasoning:
1. The code initializes the `li[]` array to store the last index of occurrence of a character.
2. Then, in the for loop, it sets the current index in `li[]` using `li[i] = i;` This line should use `li[idx] = i;` instead.
3. This is because we want to store the last index of occurrence of the character represented by `idx` in the `li[]` array.
4. By fixing this logical error, we can ensure that the correct index of occurrence is being stored in the `li[]` array.

Here's the fixed code:

```java
class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        Integer li[] = new Integer[26];
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        char[] c = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            int curr = (2 * (dp[i - 1] % mod)) % mod;
            int idx = c[i - 1] - 'a';
            if (li[idx] != null) dp[i] = (curr - dp[li[idx] - 1] + mod) % mod;
            else dp[i] = curr;
            li[idx] = i;
        }
        return (dp[n] - 1 + mod) % mod;
    }
}
```