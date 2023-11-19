The bug in the provided code is that the closing parenthesis is missing in the `Arrays.sort(citations` line. 

To fix this bug, we need to add the closing parenthesis after `citations`. Additionally, we can remove the unnecessary semicolon after `Arrays.sort(citations)`.

Here is the fixed code:

```java
import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            int hlen = (n - 1) - i + 1;
            if (citations[i] >= hlen) {
                return hlen;
            }
        }
        return 0;
    }
}
```