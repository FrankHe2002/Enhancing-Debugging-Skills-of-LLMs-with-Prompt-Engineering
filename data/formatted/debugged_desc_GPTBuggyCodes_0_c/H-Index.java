The bug in the code is in the for loop condition. The condition should be `i < n` instead of `i <= n` as the array index is 0-based and should go up to `n-1`.

Here's the fixed code:
```java
import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            int hlen = (n - i);
            if (citations[i] >= hlen) {
                return hlen;
            }
        }
        return 0;
    }
}
```