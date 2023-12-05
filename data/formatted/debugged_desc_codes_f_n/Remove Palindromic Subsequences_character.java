Fix:
```java
class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        } else if (new StringBuilder(s).reverse().toString().equals(s)) {
            return 1;
        }
        return 2;
    }
}
```