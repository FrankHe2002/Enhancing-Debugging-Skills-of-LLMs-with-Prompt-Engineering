```java
// version 1 : O(mn) space
class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();

        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int misMatchCount = 0;
                for (int k = 0; i + k < m && j + k < n; k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        misMatchCount++;
                    }
                    if (misMatchCount == 1) {
                        res++;
                    } else if (misMatchCount > 1) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
```