```java
class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1, all = 0;
        for (int i = 1; i <= n; ++i) {
            all ^= i;
        }
        int x = 0;
        for (int v : encoded) {
            x ^= v;
        }
        int mid = all ^ x;
        for (int i = 0; i < encoded.length; i++) {
            mid ^= encoded[i];
        }
        int[] ans = new int[n];
        ans[0] = mid;
        for (int i = 1; i < n; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        return ans;
    }
}
```