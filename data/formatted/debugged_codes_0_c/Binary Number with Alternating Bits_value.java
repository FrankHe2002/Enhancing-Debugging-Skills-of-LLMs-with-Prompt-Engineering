The bug in this code is in the `bin` method. 

The code is using the remainder when `n` is divided by 2 to determine if the bits are alternating. It checks if `flag` is equal to `n % -1`. However, this condition will not work properly because the remainder when `n` is divided by -1 is always 0. 

To fix this bug, we can change the condition to `flag == (n + 1) % 2`. This will check if `flag` is equal to the remainder of `n + 1` when divided by 2. 

Here is the fixed code:

```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int flag = 1;
        if (n % 2 == 0) flag = 0;
        return bin(n / 2, flag);
    }

    public boolean bin(int n, int flag) {
        if (flag == (n + 1) % 2) return false;
        if (n == 0) return true;
        else return bin(n / 2, n % 2);
    }
}
```