```java
// Runtime: 4 ms (Top 15.97%) | Memory: 42.1 MB (Top 76.75%)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> unBalanced = new ArrayList<>();
        List<String> balanced = new ArrayList<>();

        int numSpaces = 0;

        StringBuffer sb = new StringBuffer();
        StringBuilder space = new StringBuilder(" ");

        for (String word : words) {
            if (sb.length() != 0) {
                sb.append(space);
                sb.append(word);
            } else {
                sb.append(word);
            }

            if (sb.length() > maxWidth) {
                String truncated = sb.toString().replaceFirst(" ", "");
                unBalanced.add(truncated);
                sb = new StringBuffer();
                sb.append(word);
            }
        }

        numSpaces = maxWidth - sb.length();

        balanced.add(sb + space.toString().repeat(numSpaces));

        return balanced;
    }
}
```