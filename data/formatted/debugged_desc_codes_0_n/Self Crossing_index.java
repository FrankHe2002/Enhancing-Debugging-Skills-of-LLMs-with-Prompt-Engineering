```java
class Solution {

    public boolean isSelfCrossing(int[] x) {
        boolean arm = false;
        boolean leg = false;
        for (int i = 3; i < x.length; ++i) {
            int a = x[i-2] - x[i-4];
            int b = x[i-1];

            if (arm && x[i] >= b) return true;  // cross [i - 2]
            if (leg && x[i] >= a && a > 0) return true;  // cross [i - 4]

            if (x[i] < a) arm = true;
            else if (x[i] <= b) leg = true;
        }
        return false;
    }

    private int f(int[] x, int index) {
        return (index < 0) ? 0 : x[index];
    }
}
```