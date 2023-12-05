```java
class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (int k = 0; k < words.length; k++) {
            if (words[k].length() > s.length()) {
                continue;
            }

            int i = 0;
            int j = 0;
            while (i < words[k].length() && j < s.length() && words[k].charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }
            if (i == words[k].length()) {
                count++;
            }
        }
        return count;
    }
}
```