Bug Type: Index Out of Bounds Exception

Reasoning:
1. The first loop in the `nextPermutation` method is used to find the index of the element that needs to be swapped. However, the condition in the if statement `nums[i] > nums[i - 2]` seems incorrect. It should be `nums[i] > nums[i - 1]`, as we are comparing the current element with the previous element.
2. In the second loop, the condition `i > nextOfPeak` should be changed to `i >= nextOfPeak`, so that we also consider the case where the next element is equal to the peak element.
3. The variable `reversalPoint` is assigned the value of `i` instead of `i - 1`, as `i` is the index of the element greater than the peak, not the index of the peak element itself in the array.

Fix:
1. Change the condition in the first loop to `nums[i] > nums[i - 1]`.
2. Change the condition in the second loop to `i >= nextOfPeak`.
3. Assign `reversalPoint` the value of `i - 1` instead of `i`.

Fixed Code:
```java
// Runtime: 1 ms (Top 91.93%) | Memory: 43.7 MB (Top 52.39%)

class Solution {
    public void nextPermutation(int[] nums) {
        // FIND peek+1
        int nextOfPeak = - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
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
                reversalPoint = i - 1;
                break;
           