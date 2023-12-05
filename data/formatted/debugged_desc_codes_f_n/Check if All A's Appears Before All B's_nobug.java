Fix:

```java
// Runtime: 3 ms (Top 6.51%) | Memory: 40.1 MB (Top 97.53%)
class Solution {
    public boolean checkString(String s) {
        int bIndex = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                continue;
            } else if (s.charAt(i) == 'b') {
                if (bIndex == -1) {
                    bIndex = i;
                } else {
                    if (bIndex < i) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
```