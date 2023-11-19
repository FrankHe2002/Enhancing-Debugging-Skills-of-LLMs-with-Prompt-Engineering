```java
// Runtime: 1 ms (Top 99.39%) | Memory: 39.7 MB (Top 93.98%)
class Solution {
    public int[] diStringMatch(String s) {
        int low = 0;
        int high = s.length();
        int[] ans = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = low++; // fixed bug: should be low++ instead of high++
            } else {
                ans[i] = high--;
            }
        }
        ans[s.length()] = high;
        return ans;
    }
}
```