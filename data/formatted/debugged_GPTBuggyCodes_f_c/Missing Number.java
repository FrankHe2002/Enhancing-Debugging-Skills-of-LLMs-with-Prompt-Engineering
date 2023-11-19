Bug Type: Logical Error

Reasoning:
In the first approach, the bug occurs in the line `return expectedSum + 1;` where an extra `+1` is added to the expected sum. Since the expected sum was already calculated by subtracting the elements in the array, adding `+1` here leads to an incorrect result.

In the second approach, there is no bug. The code correctly calculates the missing number using XOR operations.

In the third approach, the bug occurs in two places. In the `swap` function, `nums[i] - 1` should be used instead of `nums[i]` to correctly get the index to swap with. In the return statement of the main function, `j+1` should be returned instead of `j` to get the missing number.

Fixed Code:
```java
// Approach 1: Find diff

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        for (int num : nums)
            expectedSum -= num;
        return expectedSum; // Remove +1 here
    }
}

// Approach 2: XOR
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        for (int i = 1; i <= nums.length; i++)
            xor1 = xor1 ^ i;

        int xor2 = 0;
        for (int num : nums)
            xor2 = xor2 ^ num;
        return xor1 ^ xor2;
    }
}

// Approach 3: Cyclic sort
class Solution {
    public int missingNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {

            if (nums[i] != i && nums[i] < nums.length)
                swap(i, nums[i]-1, nums); // Subtract 1 from nums[i] here
            else
                i += 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j)
                return j+1; // Change to j+1 here
        }
        return nums.length;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```