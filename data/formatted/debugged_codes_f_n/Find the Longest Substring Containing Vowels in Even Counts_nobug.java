```java
import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0, mask = 0, n = s.length();
        HashMap<Integer, Integer> seen = new HashMap<>(); // key --> Mask, value --> Index
        seen.put(0, -1);
        
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i); // Fix: store the character as char instead of integer

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { // check only vowels and skip consonant
                int bit = 1 << (c - 'a');
                mask = mask ^ bit;
                seen.putIfAbsent(mask, i);
            }
            
            res = Math.max(res, i - seen.get(mask));
        }
        
        return res;
    }
}
```