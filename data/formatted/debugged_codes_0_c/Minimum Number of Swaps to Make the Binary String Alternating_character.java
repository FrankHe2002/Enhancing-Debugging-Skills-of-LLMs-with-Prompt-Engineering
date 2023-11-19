The bug in the provided Java code is a missing semicolon in the `countSwaps` method. 

To identify this bug, we need to read the code carefully and look for any syntax errors or missing/extra characters. In this case, we can see that the `countSwaps` method is missing a semicolon after the `wrongPosition++` statement. This will result in a compilation error.

To fix the bug, we simply need to add a semicolon at the end of the line `wrongPosition++` in the `countSwaps` method.

Here is the fixed code:
```java
class Solution {
    public int minSwaps(String s) {
        int cntZero = 0, cntOne = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') cntZero++;
            else cntOne++;
        }

        //Invalid
        if (Math.abs(cntOne - cntZero) > 1) return - 1;


        if (cntOne > cntZero) {  //one must be at even position
            return countSwaps(s, '1');
        } else if (cntOne < cntZero) {
            return countSwaps(s, '0'); //zero must be at even position
        }

        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }

    //wrong count
    private int countSwaps(String s, char start) {
        int wrongPosition = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != start) wrongPosition++;
        }
        return wrongPosition;
    }
}
```