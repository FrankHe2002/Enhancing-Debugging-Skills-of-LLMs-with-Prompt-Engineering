Fix:
```java
// Runtime: 0 ms Top 100.0%) | Memory: 39.24 MB (Top 48.0%)

class Solution {
    public boolean isSameAfterReversals(int num) {
        String reversed1 = new StringBuilder(String.valueOf(num)).reverse().toString();
        String reversed2 = new StringBuilder(reversed1).reverse().toString();
        return reversed2.equals(String.valueOf(num));
    }
}
```