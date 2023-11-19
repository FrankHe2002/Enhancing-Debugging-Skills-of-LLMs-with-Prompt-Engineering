Buggy Code Fix:
```java
class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray()) c ^= cs;
        for (char ct : t.toCharArray()) c ^= ct;
        
        // Fixing the bug by returning the uppercase letter
        return c;
    }
}
```