```java
// Runtime: 4 ms (Top 96.95%) | Memory: 39.8 MB (Top 99.67%)
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int i = s.length() - 1;
        while (i >= 0) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == st.peek()) {
                st.pop(); // Fixed line
            } else {
                st.push(ch);
            }
            i--;
        }
        StringBuilder ans = new StringBuilder("");
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }
}
```