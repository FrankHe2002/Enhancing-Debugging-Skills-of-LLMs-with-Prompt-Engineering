```java
// Runtime: 23 ms (Top 33.08%) | Memory: 50 MB (Top 44.62%)
class Solution {

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public long countVowels(String word) {
        long count = 0;
        int len = word.length();

        for (int start = 0; start < len; start++) {
            for (int end = start + 1; end <= len; end++) {
                String substring = word.substring(start, end);
                for (int i = 0; i < substring.length(); i++) {
                    if (isVowel(substring.charAt(i))) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
```