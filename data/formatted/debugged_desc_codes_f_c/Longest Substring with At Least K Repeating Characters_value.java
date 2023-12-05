Fix:

```java
// Runtime: 1034 ms (Top 5.0%) | Memory: 40.68 MB (Top 79.2%)

// Solution 1: O(n^2) brute force
// time O(n^2)
// space O(1)
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }

        int[] map = new int[26]; // letter -> freq
        int n = s.length();
        int max = 0; // length of longest substring T so far
        for (int i = 0; i < n; i++) {
            Arrays.fill(map, 0);
            for (int j = i; j < n; j++) {
                map[s.charAt(j) - 'a']++;
                if (isValid(s.substring(i, j + 1), k)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    private boolean isValid(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                return false;
            }
        }
        return true;
    }
}
```