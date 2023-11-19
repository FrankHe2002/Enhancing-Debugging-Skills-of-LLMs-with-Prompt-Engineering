Bug Type: Logic Error

The provided code has a logic error. It tries to find the number of bit flips needed to make `a1` equal to `a2`. However, the logic used in the while loop to count the number of bit flips is incorrect.

To fix this issue, we need to modify the logic in the while loop and apply the XOR operator to `a1` and `a2`. By doing so, we can check the position of the differing bits and count the number of 1s present.

Fixed Code:
```java
class Solution {
    public static int minBitFlips(int a1, int a2) {
        int n = a1 ^ a2;
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
```