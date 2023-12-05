```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 3 != 0) {
            return false;
        } else {
            return isPowerOfThree(n / 3); // recurssion
        }
    }
}
```