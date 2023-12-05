```java
// Runtime: 1196 ms | Memory: 36.3 MB

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