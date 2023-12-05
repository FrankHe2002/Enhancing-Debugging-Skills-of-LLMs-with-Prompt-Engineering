There is a bug in the `countEven` method in the provided Java code. 

1. The `sumDig` method calculates the sum of the digits correctly.
2. However, the `countEven` method does not correctly check whether the sum of the digits is even or not.

To fix the bug, I will update the `countEven` method to correctly use the `sumDig` method to check if the sum of digits is even.

Here is the updated code:

```java
class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++)
            if (sumDig(i))
                count++;
        return count;
    }

    private boolean sumDig(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 2 == 0;
    }
}
```