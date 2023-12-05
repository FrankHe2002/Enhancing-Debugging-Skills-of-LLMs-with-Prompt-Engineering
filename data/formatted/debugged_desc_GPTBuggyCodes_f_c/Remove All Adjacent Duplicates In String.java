The bug in the code is that the `remove` method is being used to remove the top element from the `Stack`. This is the bug because the correct method to use to remove the top element from a `Stack` in Java is `pop` and not `remove`.

The fix involves replacing `st.remove(st.peek())` with `st.pop()`.

Here's the fixed code:
```java
import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int i = s.length() - 1;
        while (i >= 0) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == st.peek()) {
                st.pop();
            } else {
                st.push(ch);
            }
            i--;
        }
        StringBuilder ans = new StringBuilder("");
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
```