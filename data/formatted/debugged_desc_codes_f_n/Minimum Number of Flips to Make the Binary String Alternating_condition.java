```java
class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int mininumFlip = Integer.MAX_VALUE;

        for (int start = 0; start < 2; start++) {
            int flipCount = 0;
            for (int i = 0; i < n; i++) {
                if ((s.charAt(i) - '0') != ((i + start) % 2)) {
                    flipCount++;
                }
            }
            mininumFlip = Math.min(mininumFlip, flipCount);
        }

        return mininumFlip;
    }
}
```