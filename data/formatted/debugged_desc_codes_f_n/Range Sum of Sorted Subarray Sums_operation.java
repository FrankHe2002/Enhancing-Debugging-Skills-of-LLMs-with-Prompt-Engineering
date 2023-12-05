```java
class Solution {
    private static int mod = (int) 1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);

        for (int i = 0; i < n; i++) pq.add(new int[] {i, nums[i]});

        int ans = 0;
        int[] arr = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            arr[index++] = sum;
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                arr[index++] = sum;
            }
        }
        Arrays.sort(arr);
        for (int i = left - 1; i <= right - 1; i++) {
            ans = (ans + arr[i]) % mod;
        }
        return ans;
    }
}
```