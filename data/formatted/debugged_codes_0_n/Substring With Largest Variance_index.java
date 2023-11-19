```java
class Solution {
    public int largestVariance(String s) {

        int MB = 26; // Added missing declaration

        int[] freq = new int[MB];
        for (int i = 0; i < s.length(); i++)
            freq[(int) (s.charAt(i) - 'a')]++;

        int maxVariance = 0;
        for (int a = 0; a < MB; a++) { // Changed 26 to MB
            for (int b = 0; b < MB; b++) { // Changed 26 to MB
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

                    if (currAFreq > 0)
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);

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