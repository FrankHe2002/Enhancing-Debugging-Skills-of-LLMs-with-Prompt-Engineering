The bug in the provided code is in the loop that adds substrings to the HashSet. The substring function should be `s.substring(i, i + k)` instead of `s.substring(i, i - k)`. 

Here's the corrected code:

```java
import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            hs.add(s.substring(i, i + k));
        }
        return hs.size() == Math.pow(2, k);
    }
}
```