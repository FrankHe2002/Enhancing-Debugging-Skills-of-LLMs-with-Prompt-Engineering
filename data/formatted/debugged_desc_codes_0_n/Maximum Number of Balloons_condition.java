```java
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
        int min = tFrequencies[word.charAt(1) - 'a'] / 2; // Changed wFrequencies to tFrequencies here
        for (int i = 0; i < 26; ++ i) {
            if (wFrequencies[i] > 0) {
                final int count = (tFrequencies[i] / wFrequencies[i]);
                if (count < min) { // Changed > to < here
                    min = count;
                }
            }
        }
        return min;
    }

}
```