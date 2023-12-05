```java
class Solution {
    public int findNthDigit(int n) {

        if (n < 10)
            return n;

        // Use long to handle large numbers
        long currDigitIndex = 10;
        int tillNextIncrease = 90;
        int currNumberSize = 2;
        int currNumber = 10;
        int next = tillNextIncrease;

        while (currDigitIndex < n) {

            currNumber++;
            currDigitIndex += currNumberSize * next;
            next--;

            if (next == 0) {
                currNumberSize++;
                tillNextIncrease *= 10;
                next = tillNextIncrease;
            }
        }

        int nthDigit = 0;
        if (currDigitIndex == n) {
            nthDigit = currNumber % 10;
        } else {
            for (long i = currDigitIndex; i > n; i--) {
                nthDigit = currNumber % 10;
                currNumber /= 10;
            }
        }

        return nthDigit;
    }
}
```