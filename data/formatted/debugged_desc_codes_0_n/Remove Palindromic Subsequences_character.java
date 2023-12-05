```java
// Runtime: 0 ms (Top 100.00%) | Memory: 39.1 MB (Top 19.55%)
class Solution {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return 2;
            }
        }
        return 1;
    }
}
```