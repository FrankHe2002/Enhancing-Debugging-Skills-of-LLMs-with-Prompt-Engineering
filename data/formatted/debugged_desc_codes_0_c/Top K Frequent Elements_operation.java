The bug in the code is a typo in the `mapToInt` method. The arrow function should be `x -> x` instead of `x *> x`.

Here's the corrected code:

```java
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .mapToInt(x -> x)
                .limit(k)
                .toArray();
    }
}
```