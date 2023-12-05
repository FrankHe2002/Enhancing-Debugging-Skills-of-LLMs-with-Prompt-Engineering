```java
class Solution {
    private int calculateCost(int[] nums, int start) {
        int res = 0;
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, nums.length); 

        for (int i = start; i < n; i += 2) {
            int prev = (i == 0) ? Integer.MAX_VALUE : arr[i - 1];
            int cur = arr[i];
            int next = (i == n - 1) ? Integer.MAX_VALUE : arr[i + 1];

            if (prev - cur >= 0) {
                res += prev - cur + 1;
                arr[i - 1] = cur - 1;
            }
            if (next - cur >= 0) {
                res += next - cur + 1;
                arr[i + 1] = cur - 1;
            }
        }
        return res;
    }

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(calculateCost(nums, 0), calculateCost(nums, 1));
    }
}
```