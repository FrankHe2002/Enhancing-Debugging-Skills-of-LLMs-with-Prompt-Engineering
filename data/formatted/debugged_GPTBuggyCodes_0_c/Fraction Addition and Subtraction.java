Bug type: Arithmetic error (division by zero)

Bug explanation:
The bug occurs in the private `add` method. If `ret[0]` is equal to zero, then `ret[1]` is set to 1, resulting in a division by zero error when calculating `ret[0] /= g`. 

Fix:
To fix the bug, we need to check if `ret[1]` is equal to zero before dividing `ret[0]` by `g`. If `ret[1]` is zero, we can simply return `ret` as it is without performing any division.

Fixed code:
```java
class Solution {
    //Great Common Divisor 
    private int gcd(int a, int b) {
        int r = b % a;
        if (r == 0) return a;
        return gcd(r, a);
    }

    private int[] add(int[] a, int[] b) {
        if (a[0] == 0) return b;
        if (b[0] == 0) return a;
        int[] ret = new int[] {a[0] * b[1] + b[0] * a[1], a[1] * b[1]};
        if (ret[0] == 0) {
            ret[1] = 1;
            return ret;
        }
        int sign = ret[0] < 0 ? - 1 : 1;
        ret[0] *= sign;
        int g = gcd(Math.min(ret[0], ret[1]), Math.max(ret[0], ret[1]));
        if (g > 1) {
            ret[0] /= g;
            if (ret[1] != 0) {
                ret[1] /= g;
            }
        }
        ret[0] *= sign;
        return ret;
    }

    public String fractionAddition(String expression) {
        return Stream.of(
                expression.replaceAll("\\-", "+-").split("\\+")).filter(s -> s.length() > 0).map(
                s -> s.split("/")).map(
                a -> new int[] {Integer.parseInt(a[0]), Integer.parseInt(a[1])}).reduce((a, b) -> add(a, b)).map(p -> p[0] + "/" + p[1]).get();

    }
}
```