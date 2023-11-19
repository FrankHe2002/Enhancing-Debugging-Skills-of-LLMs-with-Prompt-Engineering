```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                int missingCount = arr[i] - arr[i - 1] - 1;
                if (missingCount >= k) {
                    return arr[i - 1] + k;
                } else {
                    k -= missingCount;
                }
            }
        }

        return arr[arr.length - 1] + k;
    }
}
```