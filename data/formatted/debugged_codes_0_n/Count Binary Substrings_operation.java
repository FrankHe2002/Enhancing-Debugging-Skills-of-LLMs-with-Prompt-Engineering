```java
// Runtime: 16 ms (Top 47.54%) | Memory: 49 MB (Top 60.10/)
class Solution {
    public int countBinarySubstrings(String s) {
        int i, prevRunLength = 0, curRunLength = 1, count = 0;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                prevRunLength = curRunLength;
                curRunLength = 1;
            } else {
                curRunLength++;
            }
            if (prevRunLength >= curRunLength) {
                count++;
            }
        }
        return count;
    }
}
```