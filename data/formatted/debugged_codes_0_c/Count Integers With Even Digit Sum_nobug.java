The bug in the provided code is in the `sumDig` method. The `sumDig` method is supposed to calculate the sum of the digits in a given number and return `true` if the sum is even, and `false` otherwise. 

To fix the bug, we need to change the condition in the return statement of the `sumDig` method. Currently, the condition `(sum & 1) == 0 ? true : false` is used, which checks if the sum is even, but the expression can be simplified.

Updated code with the bug fix:

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

Now, the condition `(sum % 2) == 0` is used to check if the sum is even. The updated code should fix the bug.