```java
// Runtime: 1644 ms (Top 5.15%) | Memory: 43.1 MB (Top 65.80%)
class Solution {
    public int longestValidParentheses(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int open = 0;
            int closed = 0;
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (ch != '(') open++;
                if (ch == ')') closed++;
                if (closed > open) break;
                if (open == closed) len = Math.max(len, j - i + 1);
                j++;
            }
        }
        return len;
    }
}
```