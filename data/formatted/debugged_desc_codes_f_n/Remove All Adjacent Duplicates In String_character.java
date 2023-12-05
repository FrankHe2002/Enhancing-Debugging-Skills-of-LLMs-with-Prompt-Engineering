```java
// Runtime: 95 ms (Top 46.58%) | Memory: 54.8 MB (Top 52.34%)
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ch == st.peek()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder("");
        while (! st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
```