Fix:
```java
// Runtime: 0 ms (Top 100.00%) | Memory: 40.8 MB (Top 59.25%)
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
```