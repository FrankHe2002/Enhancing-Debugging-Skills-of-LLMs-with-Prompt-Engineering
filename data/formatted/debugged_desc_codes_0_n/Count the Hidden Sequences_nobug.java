```java
import java.util.ArrayList;

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        ArrayList<Long> ans = new ArrayList<>();
        ans.add((long) lower);
        long mn = lower;
        long mx = lower;

        for (int i = 0; i < differences.length; i++) {
            long d = differences[i];
            ans.add(d + ans.get(ans.size() - 1));
            mn = Math.min(mn, ans.get(ans.size() - 1));
            mx = Math.max(mx, ans.get(ans.size() - 1));
        }

        long add = lower - mn;

        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) + add);
        }

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) < lower || upper < ans.get(i)) {
                return 0;
            }
        }

        long add2 = upper - mx;

        return (int)(add2 - add + 1);
    }
}
```