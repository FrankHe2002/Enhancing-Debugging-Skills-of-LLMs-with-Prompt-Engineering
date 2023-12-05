The bug in the provided code is in the kthDistinct method. The logic for finding the kth distinct string is incorrect.

To fix the bug, we need to iterate through the array again and keep track of the number of distinct strings encountered so far. When we reach the kth distinct string, we return it.

Here's the fixed code:

```java
// Runtime: 5 ms (Top 99.0%) | Memory: 2.48 MB (Top 20.1%)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int distinctCount = 0;
        for (String s : arr) {
            if (map.get(s) == 1 && ++distinctCount == k) {
                return s;
            }
        }
        return "";
    }
}
```