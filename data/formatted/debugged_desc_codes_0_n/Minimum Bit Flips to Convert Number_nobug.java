```java
class Solution {
    public static int minBitFlips(int start, int goal) {
        int n = (start ^ goal);
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}
```