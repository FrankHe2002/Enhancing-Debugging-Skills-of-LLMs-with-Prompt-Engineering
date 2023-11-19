```java
class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        long mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            res = ((res << Integer.toBinaryString(i).length()) % mod + i) % mod;
        }
        return (int) res;
    }
}
```