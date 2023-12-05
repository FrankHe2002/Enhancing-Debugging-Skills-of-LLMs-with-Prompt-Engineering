```java
// Runtime: 9 ms (Top 35.90%) | Memory: 48.6 MB (Top 38.52%)
class Solution {
    public int[] diStringMatch(String s) {
        int low = 0;
        int high = s.length();
        int[] ans = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }
        }
        ans[s.length()] = high;
        return ans;
    }
}
```