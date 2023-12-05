```java
// Runtime: 0 ms Top 100.0%) | Memory: 39.24 MB (Top 48.0%)

class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num == 0) {
            return true;
        }
        return (num % 10 != 0);
    }
}
```