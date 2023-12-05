```java
// Runtime: 3 ms (Top 74.73%) | Memory: 39.4 MB (Top 70.31%)

class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a <= b) {
            if (((a * a) + (b * b)) == c) {
                return true;
            } else if ((((a * a) + (b * b)) < c)) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}
```