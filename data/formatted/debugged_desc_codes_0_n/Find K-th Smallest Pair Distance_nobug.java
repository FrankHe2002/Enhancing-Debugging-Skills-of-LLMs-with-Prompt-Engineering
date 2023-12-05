```java
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (noOfDistancesLessThan(mid, nums) < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int noOfDistancesLessThan(int dist, int[] nums) {
        int count = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= dist) {  // sliding window
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }
}
```