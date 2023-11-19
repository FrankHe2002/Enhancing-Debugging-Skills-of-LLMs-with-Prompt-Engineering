Bug type: Off-by-one error, ArrayIndexOutOfBoundsException

Reasoning: 
1. In the first for loop, the loop condition is `i > 0`, which will cause the loop to terminate at `i = 1`. However, accessing `nums[i - 2]` at `i = 1` will result in an `ArrayIndexOutOfBoundsException` since `nums[-1]` is outside the valid range.
2. In the second for loop, the loop condition is `i > nextOfPeak`. However, when `nextOfPeak` is equal to the last index of `nums`, the loop will not execute, skipping the necessary condition check.

Fix: 
1. Update the loop condition of the first for loop to `i >= 0`, allowing it to iterate over the entire range of `nums`.
2. Update the loop condition of the second for loop to `i >= nextOfPeak`, ensuring the loop includes the necessary condition check.

Fixed Code:
```java
// Runtime: 1 ms (Top 91.93%) | Memory: 43.7 MB (Top 52.39%)

class Solution {
    public void nextPermutation(int[] nums) {
        // FIND peek+1
        int nextOfPeak = - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                nextOfPeak = i - 1;
                break;
            }
        }

        // Return reverse Array
        if (nextOfPeak == - 1) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            return;
        }
        // Find element greater than peek
        int reversalPoint = nums.length - 1;
        for (int i = nums.length - 1; i >= nextOfPeak; i--) {
            if (nums[i] > nums[nextOfPeak]) {
                reversalPoint = i;
                break;
            }
        }

        // swap nextOfPeak && reversalPoint
        int temp = nums[nextOfPeak];
        nums[nextOfPeak] = nums[reversalPoint];
        nums[reversalPoint] = temp;

        // Reverse array from