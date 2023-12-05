Explanation:
The issue in the given code lies in the for loop condition. The loop index must go through all possible values from 0 to n -1, since the h-index value won't exceed the number of papers, n. The loop should run as long as i < n instead of i <= n.

Fix:
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