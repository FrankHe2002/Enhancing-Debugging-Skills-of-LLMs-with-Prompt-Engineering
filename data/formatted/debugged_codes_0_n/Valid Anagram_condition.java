```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] haha1 = new int[26];
        int[] haha2 = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            haha1[(int) s.charAt(i) - 97] += 1;
            haha2[(int) t.charAt(i) - 97] += 1;
        }
        for (int i = 0; i < haha1.length; ++i) {
            if (haha1[i] != haha2[i]) return false;
        }
        return true;
    }
}
```