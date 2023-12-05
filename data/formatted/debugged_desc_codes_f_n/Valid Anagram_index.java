```java
// Runtime: 5 ms (Top 73.70%) | Memory: 42.2 MB (Top 97.84%)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26]; // 26 because input contains only lower english letters
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++; // omitting 97 because 'a' is 97, it will be 0 now
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
```