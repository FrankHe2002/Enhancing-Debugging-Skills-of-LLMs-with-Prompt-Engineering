There is a logical error in the nthPalindrome method where it calculates the palindrome. It also incorrectly returns -1 for cases where the palindrome has leading zeros. Correct the palindrome calculation to address these issues.

```java
// Runtime: 121 ms (Top 54.38%) | Memory: 96.6 MB (Top 65.63%)

class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = nthPalindrome(queries[i], intLength);
        }
        return res;
    }

    public long nthPalindrome(int nth, int kdigit) {
        if (kdigit == 1) {
            return nth;
        } else if (nth == 1) {
            return (long) Math.pow(10, kdigit - 1);
        } else if (nth > 9 || nth < 1) {
            return -1;
        } else {
            long temp = (kdigit + 1) / 2;
            long palindrome = (long) Math.pow(10, temp - 1);
            palindrome += nth;
            long divisor = 10;
            for (int i = 1; i < kdigit; i++) {
                if (i < temp) {
                    palindrome *= 10;
                } else {
                    palindrome += (nth / divisor) % 10;
                    divisor *= 10;
                }
            }
            return palindrome;
        }
    }
}
```