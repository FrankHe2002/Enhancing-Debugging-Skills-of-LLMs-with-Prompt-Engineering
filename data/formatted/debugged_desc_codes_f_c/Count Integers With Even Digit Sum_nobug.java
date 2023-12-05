Fix:

The code has multiple issues. First, in the countEven method, the sumDig function should be called with the current value of i to check if the digit sum of the number is even. Secondly, the logic in the sumDig function should return true if the sum of digits is even and false otherwise. 

Additionally, it's better to use explicit comparison to ensure better readability.

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
        return (sum % 2) == 0;
    }
}
```