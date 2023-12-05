```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.2 MB (Top 20.16-)
class Solution {
    public int sumBase(int n, int k) {
        int res = 0;
        while (n > 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }
}
```