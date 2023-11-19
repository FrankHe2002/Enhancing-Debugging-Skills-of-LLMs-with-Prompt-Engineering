The bug in the provided Java code is that it is incorrectly checking if the length of string 's' is less than or equal to the length of string 't' instead of checking if the length of 's' is greater than or equal to the length of 't'. This check is done in the line:

if (s.length() <= t.length())

To fix the bug, we need to change this line to:

if (s.length() >= t.length())

Here is the corrected code:

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i, x, p = - 1;
        if (s.length() >= t.length())
            return false;
        for (i = 0; i < s.length(); i++) {
            x = t.indexOf(s.charAt(i), p + 1);
            if (x > p)
                p = x;
            else
                return false;
        }
        return true;
    }
}
```

Explanation:
1. The original code checks if the length of 's' is less than or equal to the length of 't', which is incorrect. We need to check if 's' is longer than or equal to 't' for 's' to be a subsequence of 't'.
2. By changing the check to 's.length() >= t.length()', we ensure that the length condition is correctly evaluated.
3. No other changes are required as the logic within the for loop and the return statements are correct.