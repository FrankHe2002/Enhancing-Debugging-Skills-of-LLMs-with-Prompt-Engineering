The bug in the given code is due to incorrect tracking of the balances of 'L' and 'R' in the input string. The code is not correctly counting the number of balanced substrings.

To fix the bug, we need to keep track of the counts separately for 'L' and 'R', and increment the count only when both counts are equal.

Here is the corrected code:

```java
class Solution {
    public int balancedStringSplit(String s) {
        int nl = 0;
        int nr = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'L') {
                ++nl;
            } else if (s.charAt(i) == 'R') {
                ++nr;
            }
            if (nr == nl) {
                ++count;
                nl = 0;
                nr = 0;
            }
        }
        return count;
    }
}
```