```java
// Runtime: 23 ms (Top 33.08%) | Memory: 50 MB (Top 44.62%)
class Solution {

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public long countVowels(String word) {
        long count = 0;
        int len = word.length();

        for (int pos = 0; pos < len; pos++) {
            if (isVowel(word.charAt(pos))) {
                count++;
            }
        }

        return count;
    }
}
```