```java
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, currentMinSum = 0, currentMaxSum = 0;
        for (int num : nums) {
            currentMaxSum = Math.max(currentMaxSum + num, num);
            maxSum = Math.max(maxSum, currentMaxSum);
            currentMinSum = Math.min(currentMinSum + num, num);
            minSum = Math.min(minSum, currentMinSum);
        }
        return Math.max(maxSum, -minSum);
    }
}
```