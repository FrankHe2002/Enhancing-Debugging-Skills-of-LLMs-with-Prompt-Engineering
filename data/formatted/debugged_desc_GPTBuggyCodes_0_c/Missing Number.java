The first problem seems to be logical i.e such as an incorrect algorithm for calculating the missing number. The second solution is a correct approach to solving this problem. The third solution also seems to be correct.

In the first solution, the algorithm doesn't calculate the expectedSum correctly. It subtracts num from the expectedSum without considering the current index. This results in incorrect expectedSum.

In the second solution, the code seems to be using the XOR operation to find the missing number, which should work fine.

The third solution is using swapping method to find the missing number. It is a valid approach to solve the problem.

We will fix the provided Java code as follows:

```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        for (int num : nums)
            expectedSum -= num;
        return expectedSum;
    }
}
```