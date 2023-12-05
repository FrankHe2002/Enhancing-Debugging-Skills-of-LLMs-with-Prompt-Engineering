```java
class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1, len = 0;
        boolean flag = false;
        while (j >= 0 && (flag || (! flag && s.charAt(j) != ' ')))
            if (s.charAt(j--) != ' ') {
                flag = true;
                len++;
            } else {
              flag = false;
            }
        return len;
    }
}
```