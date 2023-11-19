Buggy Code Fix:
```java
// Runtime: 11 ms (Top 76.6%) | Memory: 39.4 MB (Top 98.4%)

class Solution {
    public int maxRepOpt1(String s) {
        int[] count = new int[26];
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (i > 0) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            } else {
                left[i] = 1;
            }
            max = Math.max(max, left[i]);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < s.length() - 1) {
                if (s.charAt(i + 1) == s.charAt(i)) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = 1;
                }
            } else {
                right[i] = 1;
            }
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) == s.charAt(i + 1) && s.charAt(i) != s.charAt(i - 1)) {
                if (count[s.charAt(i - 1) - 'a'] == left[i - 1] + right[i + 1]) {
                    max = Math.max(max, left[i - 1] + right[i + 1]);
                } else {
                    max = Math.max(max, left[i - 1] + right[i + 1] + 1);
                }
            } else {
                if (count[s.charAt(i) - 'a'] == left[i]) {
                    max = Math.max(max, left[i]);
                } else {
                    max = Math.max(max, left[i] + 1);
                }
            }
        }
        if (count[s.charAt(s.length() - 1) - 'a'] != left[s.length() - 1]) {
            max = Math.max(max,