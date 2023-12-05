The bug in this code lies in the regular expression used to match valid words. The regular expression does not correctly enforce the constraint that there should be at most one hyphen and at most one punctuation mark, and it does not specifically exclude digits.

To fix this, we need to modify the regex pattern to enforce all three conditions for a valid token.

Here's the fixed code:

```java
class Solution {
    public int countValidWords(String sentence) {
        String regex = "^[a-z]+(-[a-z]+)?[!,.]?$";
        String[] arr = sentence.split("\\s+");
        int ans = 0;
        for (String s : arr) {
            if (s.matches(regex)) {
                ans++;
            }
        }
        return ans;
    }
}
```

In the fixed code:
- The regex pattern is updated to enforce that the token only contains lowercase letters, has at most one hyphen surrounded by lowercase characters, and has at most one punctuation mark at the end of the token.
- The regex pattern `r2` is removed as it is not necessary.
- We only use one regex pattern `regex` to check if a string is a valid token.
- Removed the unnecessary print statement.