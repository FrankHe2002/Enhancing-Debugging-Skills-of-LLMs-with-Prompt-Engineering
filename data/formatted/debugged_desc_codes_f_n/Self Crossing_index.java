**Fix:**

```java
class Solution {
    public boolean isSelfCrossing(int[] x) {
        boolean arm = false;
        boolean leg = false;
        for (int i = 3; i < x.length; i++) {
            if ((i >= 3 && x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) || 
                (i >= 4 && x[i - 1] == x[i - 3] && (x[i] + x[i - 4]) >= x[i - 2]) || 
                (i >= 5 && x[i - 2] >= x[i - 4] && (x[i - 3] - x[i - 1]) <= x[i - 5] && x[i - 1] <= x[i - 3] && x[i] >= (x[i - 2] - x[i - 4])))
            {
                return true;
            }
        }
        return false;
    }
}
```