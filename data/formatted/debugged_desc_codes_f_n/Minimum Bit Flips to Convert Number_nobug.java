Fix
```java
class Solution {
    public static int minBitFlips(int start, int goal) {
        int n = (start ^ goal);
        int result = 0;
        while (n != 0) {
            result++;
            n &= (n - 1);
        }
        return result;
    }
}
```