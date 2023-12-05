Explanation:
The original code has a bug with array indexing and bitwise AND operation. It throws an `ArrayIndexOutOfBoundsException` and doesn't correctly identify three consecutive odd numbers in the array.

The fix involves three parts:
1. Make sure to iterate up to the second-to-last element to avoid the `ArrayIndexOutOfBoundsException`.
2. Correct the condition to check if the current and the next two elements are odd numbers.
3. Update the condition in the second `if` statement to reset the `count` when the current number is not odd.

Fix:
```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
```