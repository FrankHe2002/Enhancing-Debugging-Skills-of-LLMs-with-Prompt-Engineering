```java
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            freq[chars.charAt(i) - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            int[] copy = Arrays.copyOf(freq, freq.length);
            boolean pass = true;
            for (int j = 0; j < word.length(); j++) {
                if (--copy[word.charAt(j) - 'a'] < 0) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                result += word.length();
            }
        }
        return result;
    }
}
```