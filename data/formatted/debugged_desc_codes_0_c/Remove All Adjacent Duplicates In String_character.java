The bug in the provided Java code is a syntax error in the while loop condition in the `removeDuplicates` method. The condition `while (! st.isEmpty() {` is missing a closing parenthesis ")".

Here's the corrected code:

```java
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

In the corrected code:
1. The syntax error in the while loop condition has been fixed by adding a closing parenthesis ")" after `!st.isEmpty()`.
2. The final string needs to be reversed before returning, as the characters are added to the StringBuilder in reverse order. I've added a call to reverse the StringBuilder before converting it to a String.

These changes fix the syntax error and ensure that the final string is correctly formed.