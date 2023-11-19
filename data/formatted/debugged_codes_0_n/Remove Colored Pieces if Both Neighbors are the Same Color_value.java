```java
class Solution {
    public boolean winnerOfGame(String colors) {
        int cntA = 0, cntB = 0;
        for (int i = 2; i < colors.length() - 1; i++) {
            if (colors.charAt(i-1) == 'A' && colors.charAt(i - 2) == 'A' && colors.charAt(i) == 'A') cntA++;
            if (colors.charAt(i-1) == 'B' && colors.charAt(i - 2) == 'B' && colors.charAt(i) == 'B') cntB++;
        }

        return cntA > cntB;
    }
}
```