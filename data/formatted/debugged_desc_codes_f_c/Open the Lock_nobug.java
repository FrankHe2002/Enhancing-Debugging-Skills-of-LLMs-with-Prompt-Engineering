The bug in the provided Java code is related to an infinite loop in traversing the digits of the wheels, and also incorrect conditional statements to calculate the numbers after rotating the wheels. 

The `for` loop from `1` to `10000` will cause an infinite loop, and the conditional logic for the wheel rotations does not guarantee moving the wheels in one step.

Also, `! (visited.contains(num1))` and `! (visited.contains(num2))` can be replaced with `!visited.contains(num1)` and `!visited.contains(num2)`, respectively.

Here's the fixed code:
```java
// Runtime: 98 ms (Top 88.24%) | Memory: 61 MB (Top 77.65%)
class Solution {
    public int openLock(String[] deadends, String target) {
// Converted target to Integer type.
        int t = Integer.parseInt(target);
        HashSet<Integer> visited = new HashSet<>();

// Converting deadend strings to Integer type. To prevent from visiting deadend, we already mark them visited.
        for (String str : deadends) {
            visited.add(Integer.parseInt(str));
        }
// BFS
        Queue<Integer> q = new ArrayDeque<>();
// We make sure that 0 itself isn't a deadend
        if (visited.contains(0)) {
            return -1;
        }
        q.add(0);
        visited.add(0);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int elem = q.remove();
                if (t == elem) {
                    return level;
                }
                // Rotating the wheels
                for (int i = 1; i <= 1000; i = i * 10) {
                    int digit = (elem / i) % 10;
                    int num1 = elem + i * (digit == 9 ? -9 : 1);
                    int num2 = elem + i * (digit == 0 ? 9 : -1);

                    if (!visited.contains(num1)) {
                        visited.add(num1);
                        q.add(num1);
                    }
                    if (!visited.contains(num2)) {
                        visited.add(num2);
                        q.add(num2);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
```