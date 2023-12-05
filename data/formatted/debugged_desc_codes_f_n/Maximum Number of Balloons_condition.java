```java
// Runtime: 3 ms (Top 74.74%) | Memory: 42.3 MB (Top 69.99%)
class Solution {

    public int maxNumberOfBalloons(String text) {
        return maxNumberOfWords(text, "balloon");
    }

    private int maxNumberOfWords(String text, String word) {
        final int[] tFrequencies = new int[26];
        for (int i = 0; i < text.length(); ++ i) {
            tFrequencies[text.charAt(i) - 'a']++;
        }
        final int[] wFrequencies = new int[26];
        for (int i = 0; i < word.length(); ++ i) {
            wFrequencies[word.charAt(i) - 'a']++;
        }
        wFrequencies['l' - 'a'] *= 2;    // Adjust frequency for double 'l' in "balloon"
        wFrequencies['o' - 'a'] *= 2;    // Adjust frequency for double 'o' in "balloon"
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++ i) {
            if (wFrequencies[i] > 0) {
                final int count = (tFrequencies[i] / wFrequencies[i]);
                if (count < min) {      // Corrected the comparison to find the minimum
                    min = count;
                }
            }
        }
        return min;
    }

}
```