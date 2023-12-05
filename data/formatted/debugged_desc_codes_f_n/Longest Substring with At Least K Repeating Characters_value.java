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
                if (isValid(map, k)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    // return true if each distinct character in the substring s[left..right] appear >= k times
    private boolean isValid(int[] map, int k) {
        for (int num : map) {
            if (num > 0 && num < k) {
                return false;
            }
        }

        return true;
    }
}
```