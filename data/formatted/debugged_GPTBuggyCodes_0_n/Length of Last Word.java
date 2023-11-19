```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.9 MB (Top 78.55%)
class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1, len = 0;
        boolean flag = false; // Fix the bug by initializing flag to false
        while (j >= 0 && (flag || (! flag && s.charAt(j) != ' ')))
            if (s.charAt(j--) != ' ') {
                flag = true;
                len++;
            }
        return len;
    }
}
```