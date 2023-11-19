Fixed Code:
```java
// Runtime: 0 ms (Top 100.00%) | Memory: 36.9 MB (Top 91.33%)
class Solution {
    public int removePalindromeSub(String s) {
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