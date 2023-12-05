Bug type: Logical Error

The function `appealSum` has a logical error in the calculation of the total appeal of all substrings. The issue seems to be in the calculation of `res`, which is adding incorrectly. 

Fix:
```java
// Runtime: 9 ms (Top 66.9%) | Memory: 43.90 MB (Top 92.4%)
import java.util.Arrays;

class Solution {
    public long appealSum(String s) {
        long res = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; ++i) {
            int j = cs[i] - 'a', prev = pos[j];
            res += (i - prev) * (long)(n - i);
            pos[j] = i;
        }
        return res;
    }
}
```