```java
// Runtime: 1 ms (Top 100%) | Memory: 36.4 MB (Top 100%)
class Solution {
    public boolean isPowerOfFour(int n) {
        return (Math.log(n) / Math.log(4)) % 1 == 0;
    }
}
```