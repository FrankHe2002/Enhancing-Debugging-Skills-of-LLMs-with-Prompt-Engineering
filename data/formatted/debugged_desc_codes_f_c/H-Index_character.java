The type of bug in the provided Java code is a syntax error. The buggy code has missing parentheses in the line "Arrays.sort(citations;".

Below is the fixed code:

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