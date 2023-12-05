The bug in the given Java code is in the for loop where the time points are being parsed. The loop condition should be "i < N" instead of "i <= N".

Explanation:
1. In the given code, the for loop condition is "i <= N", where N is the size of the timePoints list. This will cause an IndexOutOfBoundsException when trying to access the Nth element of the list as array indexes in Java are zero-based.
2. Additionally, when parsing the time points to extract the hours and minutes, the substring indices should be (0, 2) and (3, 5) respectively for the "HH:MM" format.

To fix the bug, the for loop condition should be changed to "i < N" instead of "i <= N".

Here's the fixed code:

```java
import java.util.Arrays;
import java.util.List;

// Runtime: 9 ms (Top 62.54%) | Memory: 46.9 MB (Top 41.18%)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int N = timePoints.size();
        int[] minutes = new int[N];
        for (int i = 0; i < N; i++) {
            int hr = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int min = Integer.parseInt(timePoints.get(i).substring(3, 5));
            minutes[i] = hr * 60 + min;
        }
        Arrays.sort(minutes);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            res = Math.min(res, minutes[i + 1] - minutes[i]);
        }
        int b = minutes[0];
        int a = minutes[N - 1];
        return Math.min(res, (b - a + 1440) % 1440);
    }
}
```

Changes made:
- In the for loop condition, changed "i <= N" to "i < N".
- Updated the substring indices to correctly extract the hours and minutes from the time points.