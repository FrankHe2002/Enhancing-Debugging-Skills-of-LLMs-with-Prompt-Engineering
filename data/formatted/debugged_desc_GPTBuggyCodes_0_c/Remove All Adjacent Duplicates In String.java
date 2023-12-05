The bug in the provided code is in the line `st.remove(st.peek());`, which is attempting to remove an element from the stack. The correct method to remove an element from a stack in Java is `st.pop();`.

Here is the corrected code:

```java
import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == st.peek()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder("");
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString(); // reversing to get the actual answer
    }
}
```