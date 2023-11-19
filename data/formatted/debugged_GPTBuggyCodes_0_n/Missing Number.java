```java
// Approach 1: Find diff

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        for (int num : nums)
            expectedSum -= num;
        return expectedSum + 1; // Add +1 here
    }
}

// Approach 2: XOR
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = nums.length;
        for (int i = 0; i < nums.length; i++)
            xor1 = xor1 ^ i ^ nums[i];

        return xor1;
    }
}

// Approach 3: Cyclic sort
class Solution {
    public int missingNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {

            if (nums[i] != i && nums[i] < nums.length)
                swap(i, nums[i], nums); // Removed -1 from nums[i]
            else
                i += 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j)
                return j; // Removed +1 here
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