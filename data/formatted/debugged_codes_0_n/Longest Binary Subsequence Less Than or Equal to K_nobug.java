```java
class Solution {
    public int longestSubsequence(String s, int k) {
        int numOfZeros = 0;
        int numOfOnes = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                numOfZeros++;
            } else if (ch == '1') { // Add else if condition
                double val = Math.pow(2, s.length() - i - 1);
                if (val + numOfOnes <= k) { // Modify condition
                    numOfOnes++;
                }
            }
        }
        return numOfZeros + numOfOnes;
    }
}
```