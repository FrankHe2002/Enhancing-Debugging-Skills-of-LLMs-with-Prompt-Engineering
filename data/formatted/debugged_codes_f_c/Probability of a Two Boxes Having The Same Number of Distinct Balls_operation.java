The bug in the provided code lies in the calculation of the factorial values in the `getProbability` method. 
The bug type is a logical error.

In the original code, the calculation of factorial values is incorrect. The line `fact[i] = i % fact[i - 1];` should calculate the factorial using multiplication (`*`) instead of modulo (`%`). To fix this bug, we need to change the line to `fact[i] = i * fact[i - 1];` to correctly calculate the factorial values.

Additionally, there is another issue with the `fact` array. It is declared as `double[]`, but the factorial values will always be integers. Therefore, we should change the data type of the `fact` array to `long[]`.

Lastly, we need to add a missing import statement for `java.util.Arrays` since it is used in the code.

Here is the fixed code:

```java
import java.util.Arrays;

class Solution {
    double all = 0;

    public double getProbability(int[] balls) {
        long[] fact = new long[25];
        fact[0] = 1;
        for (int i = 1; i <= 24; i++) {
            fact[i] = i * fact[i - 1];
        }
        int need = Arrays.stream(balls).sum() / 2;
        return solve(0, 0, need, new int[balls.length], balls, fact) / all;
    }

    private double solve(int idx, int got, int need, int[] cur, int[] balls, long[] fact) {
        if (need == got) {
            int colors = 0;
            double a = fact[need];
            double b = fact[need];
            for (int i = 0; i < cur.length; i++) {
                if (cur[i] == balls[i]) {
                    ++ colors;
                } else if (cur[i] == 0) {
                    -- colors;
                }
                a /= fact[cur[i]];
                b /= fact[balls[i] - cur[i]];
            }
            all += a * b;
            return colors == 0 ? a * b : 0;
        }
        if (idx == balls.length || got > need) {
            return 0;
        }
        double ans = 0;
        for (int i = 0; i <= balls[idx]; i++) { // for this level of ball, try to