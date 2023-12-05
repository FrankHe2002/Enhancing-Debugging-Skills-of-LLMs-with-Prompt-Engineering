```java
class Solution {
    public int minimumOperations(int[] nums) {
        int freq[][] = new int[100005][2];
        int i, j, k, ans = 0;
        for (i = 0; i < nums.length; i++) {
            freq[nums[i]][i & 1]++;
        }

        for (i = 1, j = k = 0; i <= 100000; i++) {
            ans = Math.max(ans, Math.max(freq[i][0] + j, freq[i][1] + k));
            j = Math.max(j, freq[i][1]);
            k = Math.max(k, freq[i][0]);
        }
        return nums.length - ans;
    }
}
```