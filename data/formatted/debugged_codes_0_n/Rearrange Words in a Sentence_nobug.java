```java
class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        Arrays.sort(words, (s, t) -> s.length() - t.length());
        String result = String.join(" ", words);
        return Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }
}
```