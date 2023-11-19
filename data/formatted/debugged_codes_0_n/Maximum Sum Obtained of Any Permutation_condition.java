```java
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] pref = new int[n + 1];
        for (int i = 0; i < requests.length; i++) {
            pref[requests[i][0]]++;
            pref[requests[i][1] + 1]--;
        }
        for (int i = 1; i < n + 1; i++) {
            pref[i] += pref[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(pref);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += ((long) pref[i] * nums[i]);
            res %= 1000000007;
        }
        return (int) res % 1000000007;
    }
}
```