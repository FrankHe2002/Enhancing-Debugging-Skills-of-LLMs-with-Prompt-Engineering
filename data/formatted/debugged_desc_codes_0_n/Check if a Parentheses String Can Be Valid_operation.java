```java
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        int canChange = Math.abs(s.chars().map(c -> c == '(' ? -1 : 1).sum());
        int needLock = Math.abs((s + locked).chars().map(c -> c == '(' ? -1 : c == ')' ? 1 : 0).sum()) / 2;
        
        return n - canChange >= 2 && canChange >= needLock;
    }
}
```