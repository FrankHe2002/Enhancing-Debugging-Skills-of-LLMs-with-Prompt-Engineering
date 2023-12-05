```java
// Runtime: 0 ms (Top 100%) | Memory: 39.1 MB (Top 100%)
class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;

        //count the spaces
        for (char c : text.toCharArray()) {
            if (c == ' ')
                spaces++;
        }

        //form word array
        String[] words = text.trim().split("\\s+");
        int nWords = words.length;

        StringBuilder sb = new StringBuilder();
        int spacesToApply = 0, extraSpaces = 0;

        //if there is only 1 word, then all spaces will be at the end
        if (nWords == 1) {
            extraSpaces = spaces;
        }

        //if there are multiple words, find the spaces to apply between words and also any extra space
        else {
            spacesToApply = spaces / (nWords - 1);
            extraSpaces = spaces % (nWords - 1);
        }

        //append every word and then apply spaces
        for (int i = 0; i < nWords - 1; i++) {
            sb.append(words[i]);

            for (int j = 0; j < spacesToApply; j++)
                sb.append(" ");
        }

        //now append last word separately, because we don't want to apply spaces after last word
        sb.append(words[nWords - 1]);

        //if there are any extra spaces that cannot be distributed among words, add them here
        for (int j = 0; j < extraSpaces; j++)
            sb.append(" ");

        return sb.toString();
    }
}
```