The bug in the provided code is in the inner loop where `prevSum` is calculated. The line `prevSum += arr[j - 1];` should be changed to `prevSum += arr[j];` because the index `j` starts from `i` and not from `i - 1`.

To fix the bug, the line `prevSum += arr[j - 1];` should be changed to `prevSum += arr[j];`. Here is the fixed code:

```java
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        // Using two loops in this question...
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int prevSum = 0;
            for (int j = i; j < arr.length; j++) {
                prevSum += arr[j];
                if ((j - i + 1) % 2 == 1) {
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