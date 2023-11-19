```java
// Runtime: 0 ms (Top 100.0%) | Memory: 38.1 MB (Top 80.0%)

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int i : hours) {
            if (i >= target) {
                count++;
            }
        }
        return count;
    }
}
```