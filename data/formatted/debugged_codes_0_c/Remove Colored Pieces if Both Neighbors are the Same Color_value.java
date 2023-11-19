The bug in the provided code is that it is not correctly counting the occurrences of three consecutive 'A's or 'B's in the given string. 

The loop in the code iterates from 1 to colors.length()-1. However, it should iterate from 2 to colors.length()-2 in order to correctly check three consecutive characters. Additionally, the condition for the loop should be i <= colors.length()-2 to include the last character in the string. 

To fix this bug, we need to modify the loop condition and adjust the if conditions accordingly.

Here is the corrected code:

```java
class Solution {
    public boolean winnerOfGame(String colors) {
        int cntA = 0, cntB = 0;
        for (int i = 2; i <= colors.length() - 2; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') 
                cntA++;
            if (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') 
                cntB++;
        }

        return cntA > cntB;
    }
}
```

This fix ensures that the loop correctly iterates over three consecutive characters at every position in the string.