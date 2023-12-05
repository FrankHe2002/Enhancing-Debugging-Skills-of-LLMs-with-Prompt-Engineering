```java
// Runtime: 1 ms (Top 83.6%) | Memory: 41.00 MB (Top 8.7%)

class Solution {
    public int minimumMoves(String s) {
        int i = 0;
        int step = 0;
        while (i < s.length() - 2) { //subtract 2 to ensure there are 3 consecutive characters
            if (s.charAt(i) == 'X') {
                i = i + 3;
                step++;
            } else {
                i++;
            }
        }
        return step;
    }
}
```