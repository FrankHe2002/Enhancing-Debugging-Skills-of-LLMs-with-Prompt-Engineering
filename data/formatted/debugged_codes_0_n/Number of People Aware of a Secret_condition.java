```java
// Runtime: 14 ms (Top 38.08%) | Memory: 41.3 MB (Top 54.72%)
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1000000007L;
        long[] shares = new long[n + 2]; // Changed the size of shares array
        long[] forgets = new long[n + 2]; // Changed the size of forgets array

        if (delay < n + 1) { // Changed the condition
            shares[delay + 1] = 1;
        }
        if (forget < n + 1) { // Changed the condition
            forgets[forget + 1] = 1;
        }

        long shareToday = 0;
        long peopleKnow = 1;
        for (int i = delay; i < n; i++) { // Changed the condition
            shareToday += shares[i] % mod;
            shareToday -= forgets[i] % mod;

            peopleKnow -= forgets[i] % mod;
            peopleKnow += shareToday % mod;

            if (i + delay < n + 1) {
                shares[i + delay] += shareToday % mod;
            }
            if (i + forget < n + 1) {
                forgets[i + forget] += shareToday % mod;
            }
        }

        return (int) (peopleKnow % mod);
    }
}
```