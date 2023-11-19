```java
// Runtime: 6 ms (Top 29.86%) | Memory: 42.3 MB (Top 50.88%)
class Solution {
    public int countAsterisks(String s) {
        boolean insidePipe = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                insidePipe = !insidePipe;
            }
            if (!insidePipe && s.charAt(i) == '*') {
                count++;
            }
        }
        return count;
    }
}
```