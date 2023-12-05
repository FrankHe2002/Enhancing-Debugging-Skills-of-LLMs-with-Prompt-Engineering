```java
// version 1 : O(mn) space
class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();

        int res = 0;
        // first col s[0:i] match t[0:0]
        for (int i = 0; i < m; i++) {
           int diffCount = 0;
           for (int j = 0; j < Math.min(m - i, n); j++) {
               if (s.charAt(i + j) != t.charAt(j)) {
                   diffCount++;
               }
               if (diffCount == 1) {
                  res++;
               }
           }
        }

        // first row s[0:0] match t[0:j]
        for (int j = 1; j < n; j++) {
           int diffCount = 0;
           for (int i = 0; i < Math.min(n - j, m); i++) {
               if (s.charAt(i) != t.charAt(j + i)) {
                   diffCount++;
               }
               if (diffCount == 1) {
                  res++;
               }
           }
        }

        return res;
    }
}
```