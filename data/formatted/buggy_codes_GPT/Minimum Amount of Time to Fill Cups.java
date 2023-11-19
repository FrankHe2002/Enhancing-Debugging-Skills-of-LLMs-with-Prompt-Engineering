
```java
// Runtime: 2 ms (Top 59.66%) | Memory: 41.5 MB (Top 48.39%)
class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int x = amount[0];
        int y = amount[1];
        int z = amount[2];
        int sum = x + y + z;
        if (x + y > z) {
            return sum / 2 + sum % 2;
        }
        // Introduce subtle bug by not handling x == 0, y == 0, and z == 0 condition
        // We can simply remove the else block to introduce the bug
        if (x == 0 && y == 0) {
            return z;
        }
        return z;
    }
}