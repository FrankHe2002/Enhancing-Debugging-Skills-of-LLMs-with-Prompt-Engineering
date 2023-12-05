```java
// Runtime: 0 ms (Top 100.00%) | Memory: 36.6 MB (Top 17.04%)
class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (m != n) return false;

        return (s + s).contains(goal);
    }
}
```