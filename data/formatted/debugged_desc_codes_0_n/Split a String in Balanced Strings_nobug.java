```java
class Solution {
    public int balancedStringSplit(String s) {
        int nl = 0;
        int nr = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'L') {
                ++nl;
            } else {
                ++nr;
            }
            if (nr == nl) {
                ++count;
                nr = 0;
                nl = 0;
            }
        }
        return count;
    }
}
```