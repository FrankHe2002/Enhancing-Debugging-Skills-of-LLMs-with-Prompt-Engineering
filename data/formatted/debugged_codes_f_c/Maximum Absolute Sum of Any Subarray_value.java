The bug in the provided code is related to the calculation of the `currentMinSum`. Instead of adding `num`, it should be subtracted to get the minimum sum. Additionally, the initialization of `currentMinSum` should be changed to 0. This bug results in an incorrect calculation of the minimum sum. 

The fix involves changing the calculation of `currentMinSum` to subtract `num` and initializing it as 0.

Fixed Code:
```java
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, currentMinSum = 0, currentMaxSum = 0;
        for (int num : nums) {
            currentMaxSum += num;
            maxSum = Math.max(maxSum, currentMaxSum);
            if (currentMaxSum < 0)
                currentMaxSum = 0;

            currentMinSum -= num;
            minSum = Math.min(minSum, currentMinSum);
            if (currentMinSum > 0)
                currentMinSum = 0;
        }
        return Math.max(maxSum, -minSum);
    }
}
```