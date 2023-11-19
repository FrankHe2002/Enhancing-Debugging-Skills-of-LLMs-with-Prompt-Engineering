```java
import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= 100000; i++) {
            set.add(i);
        }
        
        int ans = 0;
        for (int i = 0; i < events.length; i++) {
            Integer temp = set.ceiling(events[i][0]);
            if (temp == null || temp > events[i][1]) {
                continue;
            } else {
                set.remove(temp);
                ans += 1;
            }
        }
        return ans;
    }
}
```