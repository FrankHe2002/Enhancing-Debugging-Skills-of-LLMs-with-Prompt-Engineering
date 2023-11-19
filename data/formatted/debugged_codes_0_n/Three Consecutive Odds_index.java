```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n-1; i++) {
            if ((arr[i] & 1) > 0) {
                count++;
                if (count == 3) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }
}
```