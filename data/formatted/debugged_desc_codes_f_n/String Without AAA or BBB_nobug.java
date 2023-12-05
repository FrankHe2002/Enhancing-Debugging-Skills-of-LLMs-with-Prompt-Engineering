```java
// Runtime: 1 ms (Top 90.03%) | Memory: 41.4 MB (Top 67.52%)
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            boolean writeA = false;
            int length = sb.length();
            if (length >= 2 && sb.charAt(length-1) == sb.charAt(length-2)) {
                if (sb.charAt(length-1) == 'b') {
                    writeA = true;
                }
            } else {
                if (a >= b) {
                    writeA = true;
                }
            }
            if (writeA) {
                sb.append('a');
                a--;
            } else {
                sb.append('b');
                b--;
            }
        }
        return sb.toString();
    }
}
```