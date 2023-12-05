The bug in the given code is that it doesn't correctly calculate the minimum number of days needed to complete all tasks. It also doesn't consider the space between tasks of the same type.

To fix this bug, we need to keep track of the last completion day for each task type and calculate the minimum days needed based on the space between tasks of the same type.

Here's the updated code that fixes the bug:

```java
import java.util.HashMap;

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long day = 0;

        for (int item : tasks) {
            if (map.containsKey(item) && map.get(item) > day) {
                day = map.get(item) + space; // Add space between tasks of the same type
            }

            day++;
            map.put(item, day);
        }

        return day;
    }
}
```

In the updated code:
1. If the map contains the task type and the last completion day is later than the current day, we update the current day to the last completion day + space to ensure that the space constraint is satisfied.
2. When putting the item in the map, we use the current day as the value for the task type.

This fix ensures that the space constraint between tasks of the same type is correctly taken into account, thus providing the minimum number of days needed to complete all tasks.