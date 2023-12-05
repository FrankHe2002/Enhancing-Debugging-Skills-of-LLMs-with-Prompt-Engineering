```java
class Solution {
    public int numberOfMatches(int n) {
        if (n == 1) 
            return 0;
        int res;
        if (n % 2 == 0) {
            res = numberOfMatches(n / 2);
            res += n / 2;
        } else {
            res = numberOfMatches((n - 1) / 2 + 1);
            res += (n - 1) / 2;
        }
        return res;
    }
}
```