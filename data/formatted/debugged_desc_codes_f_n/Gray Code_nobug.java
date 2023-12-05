Fix:
```java
import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}
```