Fix:
```java
class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0 && n % 3 != 2) {
            n /= 3;
        }
        return n == 0;
    }
}
```