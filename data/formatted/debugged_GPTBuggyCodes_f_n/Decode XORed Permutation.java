```java
class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1, all = 0;
        for (int i = 1; i <= n; ++ i) {
            all ^= i;
        }
        int x = 0;
        for (int v : encoded) {
            x ^= v;
        }
        int mid = all ^ x; 
        for (int i = 1, j = encoded.length - 2; i < j; i += 2, j -= 2) {
            mid ^= encoded[i] ^ encoded[j];
        }
        int[] ans = new int[n];
        ans[n / 2] = mid;
        for (int i = n / 2 + 1; i < n; ++ i) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        // Fix the loop initialization condition
        for (int i = n / 2 - 1; i >= 0; -- i) {
            ans[i] = encoded[i] ^ ans[i + 1];
        }
        return ans;
    }
}
```
