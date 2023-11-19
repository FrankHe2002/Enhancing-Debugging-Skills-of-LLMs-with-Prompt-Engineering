```java
class Solution {
    public int reachNumber(int target) {
        int sum = 0, steps = 0;
        if (target == 0) return 0;
        target = Math.abs(target);
        while (sum < target) {
            steps++;
            sum += steps;
        }

        while (((sum - target) % 2 != 0)) {
            steps++;
            sum += steps;
        }
        return steps - 1;

    }
}
```