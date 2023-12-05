Fix:
```java
// Runtime: 3 ms (Top 61.66%) | Memory: 40.5 MB (Top 92.33%)
class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;

        // Count the spaces
        for (char c : text.toCharArray()) {
            if (c == ' ')
                spaces++;
        }

        // Form word array
        String[] words = text.trim().split("\\s+");
        int nWords = words.length;

        StringBuilder sb = new StringBuilder();
        int spacesToApply = 0, extraSpaces = 0;

        // If there is only 1 word, then all spaces will be at the end
        if (nWords == 1) {
            extraSpaces = spaces;
        }

        // If there are multiple words, find the spaces to apply between words and also any extra space
        else {
            spacesToApply = spaces / (nWords - 1);
            extraSpaces = spaces % (nWords - 1);
        }

        // Append every word and then apply spaces
        for (int i = 0; i < nWords - 1; i++) {
            sb.append(words[i]);

            for (int j = 0; j < spacesToApply; j++)
                sb.append(" ");
        }

        // Now append last word separately because we don't want to apply spaces after the last word
        sb.append(words[nWords - 1]);

        // If there are any extra spaces that cannot be distributed among words, add them here
        for (int j = 0; j < extraSpaces; j++)
            sb.append(" ");

        return sb.toString();
    }
}
```