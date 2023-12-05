```java
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (i + 1 >= s.length() || s.charAt(i + 1) != ')') {
                    if (open > 0) {
                        open--;
                        ans++;
                    } else {
                        ans += 2;
                    }
                } else {
                    i++;
                    if (open > 0) {
                        open--;
                    } else {
                        ans++;
                    }
                }
            }
        }
        ans += 2 * open;
        return ans;
    }
}
```