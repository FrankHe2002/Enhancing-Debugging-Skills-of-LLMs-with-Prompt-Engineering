```java
// Runtime: 7 ms (Top 48.60%) | Memory: 39.1 MB (Top 81.29%)
class Solution {
    public int singleNumber(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            numStack.push(nums[i]);
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) break;
        }
        return numStack.pop();
    }
}
```