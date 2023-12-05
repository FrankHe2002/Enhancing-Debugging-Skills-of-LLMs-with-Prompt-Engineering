The `findKthPositive` function aims to find the k-th positive integer that is missing from the sorted array of positive integers. However, several issues need to be addressed:

1. The initial comparison in the loop condition is incorrect. `arr[i - 1] <= k` would cause an `ArrayIndexOutOfBoundsException` on `i = 0`.
2. There's a logical error in the loop body calculation.

To fix these issues:
1. Change the initial check to ensure that the first element of `arr` is greater than or equal to `k`. If true, return `k`.
2. While traversing the `arr` array, compare the difference between the current element and `k` with the difference between the previous element and `k`. If the difference increases, move `k` closer to the expected missing positive integer.

Here's the fixed code:

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
```