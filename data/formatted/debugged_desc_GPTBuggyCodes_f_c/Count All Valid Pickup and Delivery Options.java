```java
class Solution {
    public int countOrders(int n) {
        long res = 1;
        long mod = 1000000007L; // Adding L to the mod value to ensure it's treated as a long
        for (int i = 1; i <= n; i++) {
            res = (res * (2 * i - 1) % mod) * i % mod; // Adding parenthesis for clarity and correct order of operations
        }
        return (int) res;
    }
}
```