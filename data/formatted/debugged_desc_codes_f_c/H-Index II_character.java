**Fixed code:**

```java
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int res = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                res = n - mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
```