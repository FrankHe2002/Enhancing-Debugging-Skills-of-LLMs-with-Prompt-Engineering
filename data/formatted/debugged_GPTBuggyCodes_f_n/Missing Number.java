Fix #1:
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

Fix #2:
```java
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        for (int i = 1; i <= nums.length; i++)
            xor1 = xor1 ^ i;

        int xor2 = 0;
        for (int num : nums)
            xor2 = xor2 ^ num;
        
        if (xor2 != 0)
            return xor1 ^ xor2;
        
        return xor1; // Add return statement for edge case when all numbers are present
    }
}
```

Fix #3:
```java
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
                return j; // Remove +1 here
        }
        return nums.length; // Return nums.length-1 here
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```