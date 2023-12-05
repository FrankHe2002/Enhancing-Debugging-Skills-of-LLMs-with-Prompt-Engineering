```java
// Runtime: 13 ms (Top 30.48/) | Memory: 52.1 MB (Top 26.29%)
class Solution {
    public int singleNumber(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; ++i) {
            numStack.push(nums[i]);
            if (i < nums.length - 1 && nums[i] != (int) numStack.peek()) break;
        }
        return numStack.pop();
    }
}
```