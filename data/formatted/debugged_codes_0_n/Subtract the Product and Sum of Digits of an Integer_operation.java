```java
class Solution {
    public int subtractProductAndSum(int n) {
        int mul = 1, sum = 0;
        while (n != 0) {
            sum += n % 10;
            mul *= (n % 10);
            n /= 10;
        }
        return mul - sum;
    }
}
```