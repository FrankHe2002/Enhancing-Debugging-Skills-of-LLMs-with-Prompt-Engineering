```java
class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int smax = -1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] >= nums[max]) {
                smax = max;
                max = i;
            } else if (smax == -1 || nums[i] >= nums[smax]) {
                smax = i;
            }
        }


        if (nums[max] >= 2 * nums[smax]) {
            return max;
        }

        return -1;

    }
}
```