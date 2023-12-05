Fix:

```java
// Runtime: 0 ms (Top 100.00%) | Memory: 35.7 MB (Top 97.73%)
class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) return startValue - target;
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        } else {
            return 1 + brokenCalc(startValue, target + 1);
        }
    }
}
```