Bug type: Logic error

Bug reasoning:

The buggy code is attempting to find the missing number in an array of integers. However, the implementation of all three approaches is incorrect, resulting in incorrect output. 

1. Approach 1: Find diff
   - This approach calculates the expected sum of the integers in the array using the formula `(n * (n + 1)) / 2`, where `n` is the length of the array. It then subtracts each number in the array from the expected sum.
   - The bug is that the loop variable `num` in the foreach loop is not subtracted from the expected sum, but instead, the loop variable `expectedSum` is subtracted. This will not yield the correct missing number.
   - The fix is to subtract `num` from `expectedSum` in the foreach loop.

2. Approach 2: XOR
   - This approach aims to find the missing number by XORing two sets of numbers: the numbers from 1 to `n` (inclusive) and the numbers in the array.
   - The bug is that the loop variable `i` in the for loop starts from 1, but it should start from 0 to include the number 0 in the XOR calculation.
   - The fix is to change the loop condition to `i < nums.length` to iterate through the entire array.

3. Approach 3: Cyclic sort
   - This approach uses the cyclic sort algorithm to sort the array in-place and find the missing number.
   - The bug is that the swapping logic in the `swap` method is incorrect. It swaps the values at indices `i` and `nums[i]`, but it should actually be swapping the values at indices `i` and `nums[i]-1` since the numbers in the array are in the range from 0 to `n-1`, whereas the indices are from 0 to `n`.
   - The fix is to change the line `swap(i, nums[i], nums);` to `swap(i, nums[i] - 1, nums);` in the `missingNumber` method.

Fixed code:

```java
// Approach 1: Find diff
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        for (int num : nums)
            expectedSum -= num;
        return expectedSum;
    }
}

