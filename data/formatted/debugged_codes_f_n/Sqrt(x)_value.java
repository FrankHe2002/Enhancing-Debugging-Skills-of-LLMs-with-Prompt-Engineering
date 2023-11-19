```java
// Runtime: 0 ms (Top 100.00%) | Memory: 36.2 MB (Top 95.32%)

class Solution {
    public int mySqrt(int x) {
        long answer = 0;
        while ((answer + 1) * (answer + 1) <= x) {
            answer += 1;
        }
        return (int) answer;
    }
}
```