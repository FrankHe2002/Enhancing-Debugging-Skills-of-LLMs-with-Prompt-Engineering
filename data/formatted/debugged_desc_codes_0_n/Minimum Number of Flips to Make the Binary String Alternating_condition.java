```java
class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int mininumFlip = Integer.MAX_VALUE;

        int misMatchCount = 0;
        for (int i = 0; i < (2 * n); i++) {
            int r = i % n;
            if ((s.charAt(r) - '0') != (i % 2 == 0 ? 1 : 0)) misMatchCount++;
            if (i >= n && (s.charAt(r) - '0') != (r % 2 == 0 ? 1 : 0)) misMatchCount--;
            if (i >= n - 1) mininumFlip = Math.min(mininumFlip, Math.min(misMatchCount, n - misMatchCount));
        }

        return mininumFlip;
    }
}
```