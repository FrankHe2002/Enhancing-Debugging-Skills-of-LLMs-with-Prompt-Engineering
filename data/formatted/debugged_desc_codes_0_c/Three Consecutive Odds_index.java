The bug in the given code is the ArrayIndexOutOfBoundsException. It occurs when the value of i is equal to n-1 which tries to access the element arr[i+1] that goes beyond the array length.

Thinking Process:
1. The given code aims to check if there are three consecutive odd numbers in the input array.
2. While looping through the array, the code uses arr[i+1] without checking if i+1 is within the bounds of the array.
3. This can lead to an ArrayIndexOutOfBoundsException.

To fix this bug, the code should be modified to iterate until n-2 instead of n-1 to avoid accessing arr[i+1] when i is equal to n-1.

Here's the corrected code:
```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if ((arr[i] & 1) > 0 && (arr[i + 1] & 1) > 0 && (arr[i + 2] & 1) > 0) {
                return true;
            }
        }
        return false;
    }
}
```