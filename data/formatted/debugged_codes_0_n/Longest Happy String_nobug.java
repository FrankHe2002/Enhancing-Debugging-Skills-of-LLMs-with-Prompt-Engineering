```java
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int maxSize = a + b + c;
        int A = 0;
        int B = 0;
        int C = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxSize; i++) {
            if ((a >= b && a >= c && A < 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
                sb.append("a");
                a -= 1;
                A += 1;
                B = 0;
                C = 0;
            } else if ((b >= a && b >= c && B < 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                sb.append("b");
                b -= 1;
                B += 1;
                A = 0;
                C = 0;
            } else if ((c >= a && c >= b && C < 2) || (A == 2 && c > 0) || (B == 2 && c > 0)) {
                sb.append("c");
                c -= 1;
                C += 1;
                A = 0;
                B = 0;
            }
        }
        return sb.toString();
    }
}
```