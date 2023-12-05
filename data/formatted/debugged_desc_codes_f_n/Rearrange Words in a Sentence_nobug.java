```java
class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        Arrays.sort(words, (s, t) -> s.length() - t.length());
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        return String.join(" ", words);
    }
}
```