```java
class Solution {
    public int maxDistance(int[] colors) {
        int l = 0, r = colors.length - 1;
        while (colors[l] == colors[0]) l++;
        while (colors[r] == colors[colors.length - 1]) r--;
        return Math.max(r, colors.length - l - 1);
    }
}
```