Fix:
```java
class Solution {
    public int numTimesAllBlue(int[] flips) {
        int counter = 0, total = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]); // Update max value
            if (++ counter == max) total++;
        }
        return total;
    }
}
```