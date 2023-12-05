The bug in the code is a syntax error in the `countSwaps` method. The `wrongPosition++` statement should end with a semicolon. This is a simple typographical error in not ending the statement with a semicolon.

Here's the corrected code:

```java
class Solution {
    public int minSwaps(String s) {
        int cntZero = 0, cntOne = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') cntZero++;
            else cntOne++;
        }

        //Invalid
        if (Math.abs(cntOne - cntZero) > 1) return -1;


        if (cntOne > cntZero) {  //one must be at even posotion
            return countSwaps(s, '1');
        } else if (cntOne < cntZero) {
            return countSwaps(s, '0'); //zero must be at even position
        }

        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }

    //corrected wrong count
    private int countSwaps(String s, char start) {
        int wrongPosition = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != start) wrongPosition++;
        }
        return wrongPosition;
    }
}
```