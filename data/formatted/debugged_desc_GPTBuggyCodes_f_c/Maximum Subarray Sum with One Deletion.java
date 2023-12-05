```java
public class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        int ans = (int) -1e9;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
            ans = Math.max(ans, prefixSum[i]);
        }
        if (ans < 0) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            int maxSum = arr[i];
            ans = Math.max(ans, sum); // Without deleting element
            for (int j = i - 1; j >= 0; j--) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
            sum = maxSum;
            for (int j = i + 1; j < n; j++) {
                sum += arr[j];
                ans = Math.max(ans, sum); // With 1 element deleted
            }
        }
        return ans;
    }
}
```