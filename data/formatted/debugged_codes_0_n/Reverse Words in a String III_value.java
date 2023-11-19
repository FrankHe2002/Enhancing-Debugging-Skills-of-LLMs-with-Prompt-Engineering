```java
// Runtime: 8 ms (Top 29.15%) | Memory: 37.6 MB (Top 100.00%)
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().equals("")) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder resultBuilder = new StringBuilder();
        for (int j = words.length - 1; j >= 0; j--) {
            String word = words[j];
            for (int i = word.length() - 1; i >= 0; i--) {
                resultBuilder.append(word.charAt(i));
            }
            if (j > 0) {
                resultBuilder.append(" ");
            }
        }
        return resultBuilder.toString();
    }
}
```