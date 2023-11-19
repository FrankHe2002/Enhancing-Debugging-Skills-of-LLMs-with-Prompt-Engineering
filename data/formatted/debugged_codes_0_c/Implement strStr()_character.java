There is a bug in the provided code. 

Bug type: Syntax error.

Reasoning process:
1. The code does not compile because there is a syntax error in the following line:
```java
if (needle.length( == haystack.length()) {
```
2. The opening parenthesis after `needle.length` is missing its closing parenthesis.

To fix the bug, we need to add the missing closing parenthesis.

Fixed code:
```java
class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return - 1;
        }
        if (needle.length() == haystack.length()) {
            if (haystack.equals(needle)) {
                return 0;
            }
            return - 1;
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

        return - 1;
    }
}
```