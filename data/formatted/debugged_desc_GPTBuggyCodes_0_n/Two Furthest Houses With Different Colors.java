```java
class Solution {
    public int maxDistance(int[] colors) {
        int l = 0, r = colors.length - 1;
        while (colors[r] == colors[l]) l++;
        while (colors[0] == colors[r]) r--;
        return Math.max(r, colors.length - l - 1);
    }
}
```