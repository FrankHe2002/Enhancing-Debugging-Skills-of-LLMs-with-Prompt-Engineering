// Runtime: 13 ms (Top 30.48%) | Memory: 52.1 MB (Top 26.29%)
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int singleNumber(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            numStack.push(nums[i]);
            if (i < nums.length - 1 && nums[++i] != numStack.peek()) break;
        }
        return numStack.pop();
    }
}