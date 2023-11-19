```java
// Runtime: 0 ms | Memory: 38.5 MB (Top 78.53%)
class Solution {
    public int findNthDigit(int n) {
        if (n < 10)
            return n;

        long currDigitIndex = 9;
        int tillNextIncrease = 90;
        int currNumberSize = 2;
        int currNumber = 10;
        int next = tillNextIncrease;

        while (currDigitIndex < n) {
            currNumber++;
            currDigitIndex += currNumberSize;
            next--;

            if (next == 0) {
                currNumberSize++;
                tillNextIncrease *= 10;
                next = tillNextIncrease;
            }
        }

        int nthDigit = currNumber % 10;
        if (currDigitIndex > n) {
            currNumber--;

            while (currDigitIndex > n) {
                currDigitIndex--;
                nthDigit = currNumber % 10;
                currNumber /= 10;
            }
        }

        return nthDigit;
    }
}
```