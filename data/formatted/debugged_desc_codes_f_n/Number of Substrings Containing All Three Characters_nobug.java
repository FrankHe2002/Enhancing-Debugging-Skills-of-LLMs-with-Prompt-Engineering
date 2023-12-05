```java
// Runtime: 19 ms (Top 41.17%) | Memory: 45.4 MB (Top 53.10%)

class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    ++ a;
                    break;
                case 'b':
                    ++ b;
                    break;
                case 'c':
                    ++ c;
                    break;
            }
            if (a > 0 && b > 0 && c > 0) {
                count += i + 1;  // Optimized doCount function
            }
        }
        return count;
    }
}
```