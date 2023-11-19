Bug type: Logical error (incorrect shifting operation)

Reasoning: In the original code, the `p` value is left shifted (`p <<= 1`) instead of right shifted. This causes the `p` value to be incorrectly doubled instead of halved as intended, leading to an incorrect result.

Fix:
```java
class Solution {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1;
            q >>= 1;
        }
        return 1 - p % 2 + q % 2;
    }
}
```