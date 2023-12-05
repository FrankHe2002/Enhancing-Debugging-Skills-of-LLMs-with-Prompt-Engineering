The problem with the given code is that it is returning the minimum of the number of unique candies and twice the length of the candyType array. However, the correct approach should be to return the minimum of the number of unique candies and half the length of the candyType array, as the doctor advised Alice to eat n / 2 of the candies.

To fix this, we need to change the return statement to:
```
return Math.min(set.size(), candyType.length / 2);
```

Here's the modified code with the fix:

```java
import java.util.*;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) set.add(type);
        return Math.min(set.size(), candyType.length / 2);
    }
}
```