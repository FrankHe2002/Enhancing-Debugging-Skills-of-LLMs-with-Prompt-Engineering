The bug in the provided code is a missing closing parenthesis `)` after `length` in the line `max = Math.max(max, s.substring(0, i + 1).replace("1", "").length( + s.substring(i + 1).replace("0", "").length());`.

The fix is to add the missing closing parenthesis at the appropriate position.

Fixed Code:
```java
class Solution {
    public int maxScore(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++)
            max = Math.max(max, s.substring(0, i + 1).replace("1", "").length() + s.substring(i + 1).replace("0", "").length());

        return max;
    }
}
```