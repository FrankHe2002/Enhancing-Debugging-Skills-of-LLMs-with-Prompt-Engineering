```java
// Runtime: 0 ms (Top 100.0%) | Memory: 39.76 MB (Top 13.5%)

class Solution {
    public boolean hasAlternatingBits(int n) {
        int flag = n % 2;
        n = n / 2;
        return bin(n, flag);
    }

    public boolean bin(int n, int flag) {
        if (n % 2 == flag) return false;
        if (n == 0) return true;
        else return bin(n / 2, n % 2);
    }
}
```