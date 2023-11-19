The bug in the provided code is in the computation of the complement. 

To find the complement of a number, we should flip all the bits. However, the code is actually computing the sum of the powers of 2 for the bits that are not flipped.

The bug can be fixed by changing `sum += Math.pow(2, x++);` to `sum += Math.pow(2, x);` and removing the `x++` in the else block.

Here's the fixed code:

```java
class Solution {
    public int findComplement(int num) {
        int x = 0;
        int sum = 0;
        while (num > 0) {
            int i = num % 2;
            if (i == 0) {
                sum += Math.pow(2, x);
            }
            num /= 2;
            x++;
        }
        return sum;
    }
}
```

The bug has been fixed by updating the line `sum += Math.pow(2, x++);` to `sum += Math.pow(2, x);` and moving the `x++` operation to the end of the while loop. This ensures that the correct power of 2 is added to the sum for each flipped bit.