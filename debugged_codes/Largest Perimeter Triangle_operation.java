// Runtime: 9 ms (Top 60.38*) | Memory: 39.2 MB (Top 99.99%)
import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length - 3; i >= 0; i--) {
            if(nums[i] + nums[i + 1] > nums[i + 2])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }
        return 0;
    }
}