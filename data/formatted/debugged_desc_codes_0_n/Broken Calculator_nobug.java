```java
class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) return startValue - target;
        if (target <= startValue * 2) {
            return startValue * 2 - target;
        }
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        }
        return 1 + brokenCalc(startValue, target + 1);
    }
}
```