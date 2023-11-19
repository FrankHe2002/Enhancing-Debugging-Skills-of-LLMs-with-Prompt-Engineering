Buggy Code Fix:
```java
// Runtime: 1 ms (Top 100%) | Memory: 35.8 MB (Top 88.00%)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return power2(0, n);

    }

    public boolean power2(int index, int n) {
        if (Math.pow(2, index) == n)
            return true;
        if (Math.pow(2, index) > n)
            return false;
        return power2(index + 1, n);
    }
}
```