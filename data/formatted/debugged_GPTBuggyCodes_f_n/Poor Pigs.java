```java
// Runtime: 0 ms (Top 100.00%) | Memory: 35.9 MB (Top 86.46%)
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int T = (minutesToTest / minutesToDie) + 1;
        int cnt = 0;
        int total = 1;
        while (total < buckets) { // Changed the condition from "<=" to "<" to fix the bug
            total *= T;
            cnt++;
        }
        return cnt;
    }
}
```