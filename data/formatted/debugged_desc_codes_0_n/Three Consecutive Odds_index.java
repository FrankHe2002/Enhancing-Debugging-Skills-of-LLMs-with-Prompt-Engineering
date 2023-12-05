```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if ((arr[i] & 1) > 0 && (arr[i + 1] & 1) > 0 && (arr[i + 2] & 1) > 0) {
                return true;
            }
        }
        return false;
    }
}
```