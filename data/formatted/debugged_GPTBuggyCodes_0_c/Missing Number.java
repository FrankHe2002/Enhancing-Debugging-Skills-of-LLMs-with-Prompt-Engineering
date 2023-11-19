Bug type: Off-by-one error

Reviewing the code step-by-step:

1. Approach 1: Find diff
   - The code calculates the expected sum of numbers from 0 to n using the formula (n * (n + 1)) / 2.
   - It then subtracts each number in the input array from the expected sum.
   - Finally, it returns the remaining value plus 1.
   
   Potential bug: The code should return the remaining value itself, not the remaining value plus 1. By adding 1, it is offsetting the subtraction operation done in the loop by one, resulting in an incorrect answer. 

2. Approach 2: XOR
   - This approach uses the XOR operation to find the missing number.
   - It calculates the XOR of numbers from 1 to n and the XOR of all numbers in the input array.
   - The missing number is obtained by XORing the two XOR values.
   
   No bug present.

3. Approach 3: Cyclic sort
   - This approach uses the cyclic sort algorithm to place each number in its correct position.
   - It iterates through the array and swaps each number with the number at its correct index (number - 1).
   - After the sorting is complete, it checks for any index-value mismatch to find the missing number.
   
   Potential bug:
   - The swap function is called with the arguments `i` and `nums[i]-1`. However, `nums[i]-1` should be `nums[i]-1-i` to correctly get the index of the number to swap with.
   - The return statement should be `return j;` instead of `return j+1;`. By adding 1, it is incorrectly offsetting the index value by one.
   
Fixes:

1. Approach 1: Find diff
```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        for (int num : nums)
            expectedSum -= num;
        return expectedSum; // Remove +1 here
    }
}
```

2. Approach 3: Cyclic sort
```java
class Solution {
    public int missingNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {

            if (nums[i] != i && nums[i] < nums.length)
                swap(i,