The code logic seems to be correctly handling line comments and block comments. It uses a `blockActive` flag to keep track of whether it is currently processing a block comment or not. However, upon closely examining the code, it seems that there is a typo in one of the condition checks for detecting closing block comments. Let's fix that.

The issue is in the if condition `if (c == '-')` when checking for the closing block comment. It should be `if (c == '*'` instead of `if (c == '-')`. This can cause an incorrect detection of the end of a block comment.

Here's the corrected code with the fix:

```java
class Solution {
    public List<String> removeComments(String[] source) {
        boolean blockActive = false;

        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        for (String line : source) {
            if (!blockActive) {
                builder = new StringBuilder();
            }
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (!blockActive) {
                    if (c == '/') {
                        if (i < line.length() - 1 && line.charAt(i + 1) == '/') {
                            break;
                        } else if (i < line.length() - 1 && line.charAt(i + 1) == '*') {
                            i++;
                            blockActive = true;
                        } else {
                            builder.append(c);
                        }
                    } else {
                        builder.append(c);
                    }
                } else {
                    if (c == '*') { // Fix: Correct the condition for detecting closing block comments
                        if (i < line.length() - 1 && line.charAt(i + 1) == '/') {
                            blockActive = false;
                            i++;
                        }
                    }
                }
            }
            if (!blockActive && builder.length() != 0) {
                result.add(builder.toString());
            }
        }
        return result;
    }
}
```

Now the code should correctly identify the closing of block comments and remove them.