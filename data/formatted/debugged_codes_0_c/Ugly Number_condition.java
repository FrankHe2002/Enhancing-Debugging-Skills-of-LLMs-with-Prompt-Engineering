The bug in the provided code is in the while loop condition. The while loop should continue as long as n is not equal to 1, but the condition is checking if n is equal to 1. This means that if n is not initially 1, the while loop will never be entered and the function will always return true. 

To fix the bug, the condition in the while loop should be changed from `while (n == 1)` to `while (n != 1)`. 

```java
class Solution {
    public boolean isUgly(int n) {
        if (n == 0) return false; //edge case
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
```