```java
// Runtime: 0 ms Top 100.00%) | Memory: 37.2 MB (Top 95.99%)
class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1, len = 0;
        boolean flag = true;
        while (j >= 0 && (flag || (! flag && s.charAt(j) != ' '))) {
            if (s.charAt(j--) != ' ') {
                flag = false;
                len++;
            }
        }
        return len;
    }
}
```