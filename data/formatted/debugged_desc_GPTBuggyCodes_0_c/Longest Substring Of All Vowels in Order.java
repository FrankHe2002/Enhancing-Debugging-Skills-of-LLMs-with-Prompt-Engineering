The provided Java code has a bug. The bug type is logical error. The bug resides in the while loop.

To fix the bug, I will:
- Create a variable to keep track of the current character being examined.
- Change the while condition to check for the current character and the next character using 'i' and 'currentChar' variables.
- Move the check for beautiful substring length outside the while loop.

Fixed code:

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestBeautifulSubstring(String word) {
        int max = 0;
        for (int i = 1; i < word.length(); i++) {
            int temp = 1;
            Set<Character> verify = new HashSet<>();
            verify.add(word.charAt(i - 1));
            char currentChar = word.charAt(i - 1);
            while (i < word.length() && word.charAt(i) >= currentChar) {
                temp++;
                verify.add(word.charAt(i));
                currentChar = word.charAt(i);
                i++;
            }
            if (verify.size() == 5) {
                max = Math.max(max, temp);
            }
        }

        return max;
    }
}
```