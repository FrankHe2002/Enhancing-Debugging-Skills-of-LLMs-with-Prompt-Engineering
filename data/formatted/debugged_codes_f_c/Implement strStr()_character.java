The bug in the provided code is a syntax error. There is a closing parenthesis missing in the second if statement: `if (needle.length( == haystack.length())`. Additionally, there are spaces before the minus sign and after the equal sign in the return statements.

The fix is to add the missing closing parenthesis and remove the unnecessary spaces:

```java
class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == haystack.length()) {
            if (haystack.equals(needle)) {
                return 0;
            }
            return -1;
        }


        int i = 0;
        int j = 0;
        while (i < needle.length() && j < haystack.length()) {
            if (needle.charAt(i) == haystack.charAt(j)) {
                i++;
                j++;
                if (i == needle.length()) {
                    return j - needle.length();
                }
            } else {
                j = j - i + 1; // backtrack to last pos+1 where there was a probable match
                i = 0;
            }
        }

        return -1;
    }
}
```