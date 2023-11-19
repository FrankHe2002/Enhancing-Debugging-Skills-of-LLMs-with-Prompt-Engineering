```java
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int minimumFlip = Integer.MAX_VALUE;
        int mismatchCount = 0;
        
        for (int i = 0; i < (2 * n); i++) {
            int r = i % n;
            
            if ((s.charAt(r) - '0') != (i % 2 == 0 ? 1 : 0)) {
                mismatchCount++;
            }
            
            if (i >= n && (s.charAt(r) - '0') != (r % 2 != 0 ? 1 : 0)) {
                mismatchCount--;
            }
            
            if (i >= n - 1) {
                minimumFlip = Math.min(minimumFlip, Math.min(mismatchCount, n - mismatchCount));
            }
        }
        
        return minimumFlip;
    }
}
```