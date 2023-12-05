There is a bug in the provided code. The bug is in the calculation of the score when encountering ')' in the input string.

To identify the bug, let's think step by step:

1. The code uses a stack to keep track of the scores while iterating through the input string.
2. When encountering '(', the current score is pushed onto the stack and reset to 0.
3. When encountering ')', the previous score (from the top of the stack) is popped, and the calculation is performed incorrectly. The calculation should be 2 * popped_value if score is zero, otherwise popped_value + score.

To fix the bug, the calculation of the score when encountering ')' needs to be updated.

Here's the fixed code:

```java
import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(score);
                score = 0;
            } else {
                int previousScore = st.pop();
                score = previousScore + Math.max(2 * score, 1);
            }
        }
        return score;
    }
}
```
The bug was fixed by updating the calculation of the score when encountering ')' to be `previousScore + Math.max(2 * score, 1)`. This ensures that the correct score calculation is performed based on the given rules.