Bug Type: Logical Error

Reasoning: Upon reviewing the code, the bug appears to be a logical error in the condition `currDigitIndex == n` inside the first `if` statement. If `currDigitIndex` is equal to `n`, it enters a loop that keeps finding the digit until `currNumber` becomes 0. However, this loop doesn't actually update `currDigitIndex` or `n`, causing an infinite loop.

Fix: To fix the bug, we need to update `currDigitIndex` and `n` inside the loop that finds the digit. 

Fixed Code:
```java
// Runtime: 1 ms (Top 82.96%) | Memory: 36 MB (Top 91.02%)
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
        if (currDigitIndex == n) {
            while (currNumber != 0 && currDigitIndex > n) {
                nthDigit = currNumber % 10;
                currNumber /= 10;
                currDigitIndex--;
            }
        } else if (currDigitIndex > n) {

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
The fix adds `currDigitIndex--` inside the loop to decrement the `currDigitIndex` with each iteration, preventing an infinite loop.