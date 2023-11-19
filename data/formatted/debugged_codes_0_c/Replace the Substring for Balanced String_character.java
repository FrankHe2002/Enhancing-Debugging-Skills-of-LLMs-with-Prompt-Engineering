The provided Java code has a missing closing parenthesis on line 8. This is a syntax error and will prevent the code from compiling.

To fix this bug, we need to add the missing closing parenthesis on line 8. Here is the corrected code:

```java
class Solution {
    public int balancedString(String s) {
        int n = s.length(), ans = n, excess = 0;
        int[] cnt = new int[128];
        cnt['Q'] = cnt['W'] = cnt['E'] = cnt['R'] = - n / 4;
        for (char ch : s.toCharArray()) // added closing parenthesis
            if (++ cnt[ch] == 1) excess++;
        if (excess == 0) return 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (-- cnt[s.charAt(i)] == 0) excess--;
            while (excess == 0) {
                if (++ cnt[s.charAt(j)] == 1) excess++;
                ans = Math.min(i - j + 1, ans);
                j++;
            }
        }

        return ans;
    }
}
```