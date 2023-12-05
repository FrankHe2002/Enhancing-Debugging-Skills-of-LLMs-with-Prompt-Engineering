```java
// Time complexity: O(N)
// Space complexity: O(1)
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 1;
        for (int i = 0; i < arr.length - m; i++) {
            if (arr[i + m] == arr[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count == m * k) {
                return true;
            }
        }
        return false;
    }
}
```