```java
class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        int temp = x;

        while (x > 0) {
            sum = 10 * sum + x % 10;
            x /= 10;
        }

        return sum == temp;
    }
}
```