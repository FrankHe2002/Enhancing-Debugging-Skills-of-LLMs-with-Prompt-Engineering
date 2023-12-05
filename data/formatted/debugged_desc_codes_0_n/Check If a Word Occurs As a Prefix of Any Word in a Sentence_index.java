```java
// Runtime: 1 ms (Top 44.68%) | Memory: 41.8 MB (Top 51.62%)
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (!sentence.contains(searchWord))
            return -1;
        String[] str = sentence.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }
}
```