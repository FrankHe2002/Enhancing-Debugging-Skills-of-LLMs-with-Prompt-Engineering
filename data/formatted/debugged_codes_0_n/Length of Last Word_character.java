```java
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int j = s.length() - 1, len = 0;
        boolean flag = true;
        while (j >= 0 && (flag || (! flag && s.charAt(j) != ' '))) {
            if (s.charAt(j) != ' ') {
                flag = false;
                len++;
            }
            j--;
        }
        
        return len;
    }
}
```