```java
class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int count = 0;
        int i = 0;
        while (sum < n) {
            if (i < nums.length && nums[i] <= sum + 1) {
                sum += nums[i];
                i++;
            } else {
                sum += sum + 1;
                count++;
            }
        }
        return count;
    }
}
```