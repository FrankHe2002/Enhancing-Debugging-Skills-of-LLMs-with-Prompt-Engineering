```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        else if (n == - 1) return 1 / x;
        double res = myPow(x, n / 2);
        if (n % 2 == 0) return res * res;
        else if (n > 0) return res * res * x;
        else return res * res * (1 / x);
    }
}
```