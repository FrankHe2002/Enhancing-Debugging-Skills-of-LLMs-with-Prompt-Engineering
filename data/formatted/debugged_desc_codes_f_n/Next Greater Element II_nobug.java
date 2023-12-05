Fix:
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i % n]) {
                result[s.pop()] = nums[i % n];
            }
            if (i < n)
                s.push(i);
        }
        return result;
    }
}
```