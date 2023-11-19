The bug in the provided code is in the loop condition of the `sumBase` method. The condition `n > 0` should be changed to `n != 0` to ensure that the loop also includes the case when `n` is initially 0.

Additionally, the code does not handle negative values of `n` correctly. To handle negative values, we can take the absolute value of `n` before entering the loop and then add the sign back to the result at the end.

Here is the fixed code:

```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.2 MB (Top 20.16-)
class Solution {
    public int sumBase(int n, int k) {
        int res = 0;
        n = Math.abs(n);
        for (; n != 0; n /= k)
            res += n % k;
        return res;
    }
}
```