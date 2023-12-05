```java
// Runtime: 3 ms (Top 14.46%) | Memory: 41.2 MB (Top 58.53%)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
```