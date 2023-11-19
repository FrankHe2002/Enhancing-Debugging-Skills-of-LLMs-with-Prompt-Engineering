```java
class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = ((res << Integer.toBinaryString(i).length()) + i) % 1000000007;
        }
        return (int) res;
    }
}
```