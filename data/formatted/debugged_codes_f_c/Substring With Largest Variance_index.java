Bug type: Syntax Error

Reasoning: The provided code has a syntax error due to missing semicolons at the end of the statements inside the first `for` loop (line 7) and the second `for` loop (line 12).

Fix:
```java
class Solution {
    public int largestVariance(String s) {

        int[] freq = new int[MB];
        for (int i = 0; i < s.length(); i++) {
            freq[(int) (s.charAt(i) - 'a')]++;
        }

        int maxVariance = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                int remainingA = freq[a];
                int remainingB = freq[b];
                if (a == b || remainingA == 0 || remainingB == 0) continue;

                // run kadanes on each possible character pairs (A & B)
                int currBFreq = 0, currAFreq = 0;
                for (int i = 0; i < s.length(); i++) {
                    int c = (int) (s.charAt(i) - 'a');

                    if (c == b) currBFreq++;
                    if (c == a) {
                        currAFreq++;
                        remainingA--;
                    }

                    if (currAFreq > 0) {
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);
                    }

                    if (currBFreq < currAFreq && remainingA >= 1) {
                        currBFreq = 0;
                        currAFreq = 0;
                    }
                }
            }
        }

        return maxVariance;
    }
}
```