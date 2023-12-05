Fix:
```java
class Solution {
    public int findNthDigit(int n) {
        if (n < 10)
            return n;

        long numDigits = 9;
        int digits = 1;
        int start = 1;

        while (n > numDigits * digits) {
            n -= numDigits * digits;
            numDigits *= 10;
            digits++;
            start *= 10;
        }

        start += (n - 1) / digits;
        String s = Integer.toString(start);
        return s.charAt((n - 1) % digits) - '0';
    }
}
```