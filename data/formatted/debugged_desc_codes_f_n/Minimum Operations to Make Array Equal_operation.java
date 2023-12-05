```java
class Solution {
    public int minOperations(int n) {
        int ans = (n / 2) * (n - n / 2);
        return ans;
    }
}
```