The bug in the given code is that the while loop condition `p % 2 == 0 && q % 2 != 0` is not accurately checking the reflection calculation.

In the mirrorReflection function, the corner to which the laser ray will meet eventually needs to be determined based on the given input (p, q). The provided code contains an incorrect logic to calculate the reflection hence resulting in a false outcome.

The correct formula to determine the reflection of the laser in this scenario is more complex and depends on the relative values of `p` and `q`.

I will fix the code to provide the correct reflection calculation.

Fix:
```java
class Solution {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1;
            q >>= 1;
        }
        if(p % 2 == 0) {
            return 2;
        } else if(q % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
```