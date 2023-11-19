```java
// Runtime: 5 ms (Top 77.80%) | Memory: 39.1 MB (Top 95.47%)
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().equals("")) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder resultBuilder = new StringBuilder();
        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                resultBuilder.append(word.charAt(i));
            }
            resultBuilder.append(" ");
        }
        return resultBuilder.toString().trim();
    }
}
```