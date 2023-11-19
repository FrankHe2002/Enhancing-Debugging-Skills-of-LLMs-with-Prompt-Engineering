The modified code has a bug in the inner loop. The condition `(j - i + 1) % 2 == 1` should be `(j - i + 1) % 2 == 0`, because we want to calculate the sum for subarrays with odd length, not even length. 

Here is the corrected code:

```java
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        // Using two loops in this question...
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int prevSum = 0;
            for (int j = i; j < arr.length; j++) {
                prevSum += arr[j];
                if (prevSum < 0) {
                    break;
                }
                if ((j - i + 1) % 2 == 0) {
                    sum += prevSum;
                }
            }
        }
        // Time Complexity : O(n-square)
        // Space Complexity : O(1)
        return sum;
    }
}
```