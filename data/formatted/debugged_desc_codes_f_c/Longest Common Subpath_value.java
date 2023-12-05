The bug type in the given code is a logical error. The provided implementation of the 'longestCommonSubpath' method has complex logic that fails to find the longest common subpath shared by every friend's path. The solution calculates hash values and uses advanced algorithms unnecessarily overcomplicating the solution.

Here's the fixed code:

```java
class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        int left = 1, right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasCommonSubpath(paths, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean hasCommonSubpath(int[][] paths, int len) {
        for (int i = 1; i < paths.length; i++) {
            if (!hasSubpath(paths[0], paths[i], len)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSubpath(int[] p1, int[] p2, int len) {
        long h1 = 0, power = 1, mod = (long) (1e11 + 3);
        for (int i = 0; i < len; i++) {
            h1 = (h1 * 100003 + p1[i] + 1) % mod;
            power = (power * 100003) % mod;
        }
        Set<Long> s1 = new HashSet<>();
        s1.add(h1);
        for (int i = len; i < p1.length; i++) {
            h1 = (h1 * 100003 + p1[i] + 1 - p1[i - len] * power) % mod;
            s1.add(h1);
        }
        long h2 = 0;
        for (int i = 0; i < len; i++) {
            h2 = (h2 * 100003 + p2[i] + 1) % mod;
        }
        if (s1.contains(h2)) return true;
        for (int i = len; i < p2.length; i++) {
            h2 = (h2 * 100003 + p2[i] + 1 - p2[i - len] * power) % mod;
            if (s1.contains(h2)) return true;
        }
        return false;
    }
}
```
This revised code is a simplified and corrected implementation based on the original code.