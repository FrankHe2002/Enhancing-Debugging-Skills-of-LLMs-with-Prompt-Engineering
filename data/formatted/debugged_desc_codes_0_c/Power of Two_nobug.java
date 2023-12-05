The bug in the provided code is that it recursively checks all powers of 2 from 2^0 until n is found or until 2^x is greater than n. This approach is not efficient since it has a time complexity of O(log n).

To fix this, we can use a more efficient solution by checking if n is a power of 2 by looking for a single set bit in the binary representation of n. If n is a power of 2, it will have only one bit set to 1.

Here's the updated code with the fix:

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
```

In this fixed code:
- We first check if n is less than or equal to 0, and if so, return false. This accounts for the constraints provided in the problem statement.
- We then use the bitwise operation n & (n - 1) to check if n has only one bit set. If this condition is true, then n is a power of 2 and we return true, otherwise we return false.

This solution has a time complexity of O(1) and efficiently checks if a given number n is a power of 2.