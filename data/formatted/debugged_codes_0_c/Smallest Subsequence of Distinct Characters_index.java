Bug Type: Compilation Error

Reasoning Process:
1. The code provided is missing an import statement for the `Arrays` class. In order to use the `Arrays.fill()` method, the `java.util.Arrays` package needs to be imported.
2. Additionally, there is a mistake in the line `boolean[] inStack = new boolean[Character];`. The `inStack` array should be initialized with a size of 26 instead of `Character`. This is because there are 26 lowercase letters in the English alphabet.
3. Lastly, the `java.util.ArrayDeque` class needs to be imported as well to create the `dq` variable.

Fix:
Below is the fixed code:
```java
import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        boolean[] inStack = new boolean[26];
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (inStack[ch - 'a']) {
                continue;
            }
            while (! dq.isEmpty() && dq.peekLast() > ch && lastIdx[dq.peekLast() - 'a'] > i) {
                inStack[dq.pollLast() - 'a'] = false;
            }
            dq.addLast(ch);
            inStack[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (! dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}
```