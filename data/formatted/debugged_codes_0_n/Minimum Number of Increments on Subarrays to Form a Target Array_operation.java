```java
class Solution {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        int prev = target[0];
        for (int i = 1; i < target.length; i++) {
            int cur = target[i];
            if (cur > prev) {
                res += cur - prev;
            }
            prev = cur;
        }
        return res;
    }
}
```