```java
class Solution {
    public int findNthDigit(int n) {

        if (n < 10)
            return n;

        long currDigitIndex = 9;
        long tillNextIncrease = 90;
        int currNumberSize = 2;
        long currNumber = 10;
        long next = tillNextIncrease;

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

        int count = (int)(currDigitIndex - n);
        int nthDigit = 0;
        for (int i = 0; i <= count; i++) {
            nthDigit = (int)(currNumber % 10);
            currNumber /= 10;
        }

        return nthDigit;
    }
}
```