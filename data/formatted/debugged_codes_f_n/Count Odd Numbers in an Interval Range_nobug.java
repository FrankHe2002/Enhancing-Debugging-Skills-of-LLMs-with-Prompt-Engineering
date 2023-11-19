```java
// Runtime: 0 ms (Top 100.00%) | Memory: 35.4 MB (Top 5.10%)
class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        }
        return (high - low) / 2 + 1;
    }
}
```