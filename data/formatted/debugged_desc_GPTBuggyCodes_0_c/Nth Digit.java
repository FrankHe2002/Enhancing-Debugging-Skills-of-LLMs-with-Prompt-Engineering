The bug in the provided code is in the logic for finding the nth digit of the infinite integer sequence. The logic is convoluted and prone to errors. It doesn't accurately calculate the nth digit for values of n greater than 10.

Here's how we can identify and fix the bug:

1. The initial condition `if (n < 10) return n;` is problematic. It only returns the single-digit numbers correctly. The logic in the subsequent part handles two-digit numbers, but it is not properly implemented for numbers higher than 10. There are issues in finding the correct digit for these numbers.
2. A simpler and more accurate way to find the nth digit would be to use some mathematical techniques.
3. Given the inputs can be up to 10^9, using a mathematical formula to solve the problem instead of using brute force becomes necessary. 
4. The mathematical approach involves finding the length of the number range, then finding the number from which the nth digit is to be extracted and finally calculating the digit.
5. Let's implement the fix and replace the existing code.

Here's the fixed code:

```java
class Solution {
    public int findNthDigit(int n) {
        int len = 1, start = 1, count = 9;

        while (n > len * count) {
            n -= len * count;
            len++;
            start *= 10;
            count *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }
}
```

With these changes, we have implemented a more accurate and efficient approach to find the nth digit of the infinite integer sequence while avoiding the buggy logic and brute force calculations.