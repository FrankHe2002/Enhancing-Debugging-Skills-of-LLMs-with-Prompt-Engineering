```java
class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            result.add(sb.toString().stripTrailing());
        }

        return result;
    }
}
```