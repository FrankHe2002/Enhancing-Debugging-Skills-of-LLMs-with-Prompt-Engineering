```java
class Solution {
    public int singleNumber(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            numStack.push(nums[i]);
            if (i < nums.length - 1 && nums[++i] != numStack.peek()) {
                break;
            }
        }
        return numStack.pop();
    }
}
```