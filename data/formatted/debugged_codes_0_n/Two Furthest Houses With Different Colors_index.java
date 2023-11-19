```java
// Runtime: 0 ms (Top 100.00%) | Memory: 42.7 MB (Top 13.21%)
class Solution {
    public int maxDistance(int[] colors) {
        int l = 0, r = colors.length - 1;
        while (l < r && colors[colors.length - 1] == colors[l]) l++;
        while (l < r && colors[r] == colors[r]) r--;
        return Math.max(r - l, colors.length - 1 - l);
    }
}
```