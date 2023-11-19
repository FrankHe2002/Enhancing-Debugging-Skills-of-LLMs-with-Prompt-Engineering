Buggy Code Explanation:
The `triangularSum` method calls the `find` method to compute a triangular sum. However, the `find` method has a bug in the loop condition `i < n - 1`. This condition causes the loop to stop when `i` reaches `n - 2`, which skips the last element of the array. The bug results in an incorrect computation of the triangular sum. 

Additionally, the modulo operation `(a[i] % a[i + 1]) % 10` is unnecessary and causes the calculated sum to be incorrect. Removing this operation fixes the bug.

Buggy Code Fix:
```java
class Solution {
    public int triangularSum(int[] nums) {
        return find(nums, nums.length);
    }

    public int find(int[] a, int n) {
        if (n == 1)
            return a[0];

        for (int i = 0; i < n; i++) {
            a[i] = a[i] + a[i + 1];
        }
        return find(a, n - 1);
    }
}
```