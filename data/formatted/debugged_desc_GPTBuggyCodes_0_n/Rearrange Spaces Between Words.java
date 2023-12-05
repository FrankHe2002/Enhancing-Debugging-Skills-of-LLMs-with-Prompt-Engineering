```java
class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ')
                spaces++;
        }
        String[] words = text.trim().split("\\s+");
        int nWords = words.length;

        StringBuilder sb = new StringBuilder();
        int spacesToApply = 0, extraSpaces = 0;
        if (nWords > 1) {
            spacesToApply = spaces / (nWords - 1);
            extraSpaces = spaces % (nWords - 1);
        }
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(words[i]);
            for (int j = 0; j < spacesToApply; j++)
                sb.append(" ");
        }
        sb.append(words[nWords - 1]);
        for (int j = 0; j < extraSpaces; j++)
            sb.append(" ");
        for (int j = 0; j < spaces - extraSpaces - spacesToApply * (nWords - 1) ; j++)
            sb.append(" ");
        
        return sb.toString();
    }
}
```