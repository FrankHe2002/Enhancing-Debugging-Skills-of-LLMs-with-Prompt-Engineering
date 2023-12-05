```java
class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int count = 0;
        int i = 0;
        while (sum < n) {
            if (i >= nums.length || sum + 1 < nums[i]) {
                sum += sum + 1;
                ++count;
            } else {
                sum += nums[i];
                i++;
            }
        }
        return count;
    }
}
```