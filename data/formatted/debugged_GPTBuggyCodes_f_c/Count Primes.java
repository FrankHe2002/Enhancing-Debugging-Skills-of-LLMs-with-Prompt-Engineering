The bug in the provided code is in the loop condition of the outer `for` loop. It wrongly uses `<= n` instead of `< n`, which causes an `ArrayIndexOutOfBoundsException` when accessing elements in the `check` array.

To fix this, we need to change the loop condition from `i <= n` to `i < n`.

Fixed code:
```java
class Solution {
    public int countPrimes(int n) {
        boolean check[] = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (check[i] == false) {
                count++;
                for (int j = i; j < n; j += i) {
                    check[j] = true;
                }
            }
        }
        return count;
    }
}
```