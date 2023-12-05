```java
// Runtime: 71 ms (Top 53.30%) | Memory: 48.3 MB (Top 81.34%)
class Solution {
    public String removeDuplicates(String s, int k) {
        int[] count = new int[s.length()];
        StringBuilder newString = new StringBuilder(s);
        for (int i = 0; i < newString.length(); i++) {
            if (i == 0 || newString.charAt(i) != newString.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    newString.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return newString.toString();
    }
}
```