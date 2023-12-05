```java
// Runtime: 23 ms (Top 58.97%) | Memory: 54.5 MB (Top 69.23%)
class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int b[] = new int[26];
        int h = k / 26;
        int h1 = k % 26;
        for (int i = 1; i <= 26; i++) {
            b[i - 1] += h;
            if (i <= h1) b[i - 1]++;
        }

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(i)) {
                i++;
            } else {
                int diff = ((t.charAt(i) - s.charAt(i)) + 26) % 26;
                b[diff]--;
                if (b[diff] < 0) return false;
                else i++;
            }

        }
        return true;
    }
}
```