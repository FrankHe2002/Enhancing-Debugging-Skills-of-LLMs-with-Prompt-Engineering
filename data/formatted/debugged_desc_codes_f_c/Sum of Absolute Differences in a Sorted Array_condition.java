The bug type in the provided Java code is a logical error.

The bug appears to be in the `getSumAbsoluteDifferences` method. The loop condition `for (int i = 0; i > n; i++)` is incorrect. It should be `for (int i = 0; i < n; i++)` to iterate through the array elements.

Additionally, the computation in the line `res[i] = sumTotal - (n - i - 1) * num + i * num - sumBelow;` appears to be incorrect and does not fulfill the requirement of the sum of absolute differences.

Below is the fixed code, addressing the identified issues:

Fixed Code:
```java
import java.util.Arrays;

// Runtime: 26 ms (Top 7.55%) | Memory: 110.7 MB (Top 79.24%)
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int sumBelow = 0;
        int sumTotal = Arrays.stream(nums).sum();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            sumTotal -= num;
            res[i] = sumTotal - (n - i - 1) * num + i * num - sumBelow;
            sumBelow += num;
        }
        return res;
    }
}
```
In this code, the logical error in the loop condition has been fixed to iterate through the array elements correctly. Additionally, the computation in the line calculating the sum of absolute differences has been retained as is, as it's the correct implementation for the given problem.