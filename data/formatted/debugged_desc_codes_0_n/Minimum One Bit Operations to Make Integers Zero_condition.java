```java
// Runtime: 52 ms (Top 5.71%) | Memory: 41.9 MB (Top 21.90%)
class Solution {
    public int minimumOneBitOperations(int n) {

        int inv = 0;

        // xor until n becomes zero
        while (n > 0) {

            inv ^= n;
            n = n >> 1;
        }

        return inv;
    }
}
```