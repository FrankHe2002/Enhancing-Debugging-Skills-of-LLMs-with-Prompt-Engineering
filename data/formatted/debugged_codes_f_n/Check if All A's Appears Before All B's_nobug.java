```java
// Runtime: 3 ms (Top 6.51%) | Memory: 40.1 MB (Top 97.53%)
class Solution {
    public boolean checkString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'a') {
                        return false;
                    }
                }
                break; // Fix: Add break statement to exit the inner loop after finding 'b'
            }
        }
        return true;
    }
}
```