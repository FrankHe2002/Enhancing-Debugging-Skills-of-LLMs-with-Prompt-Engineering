Bug Type: Syntax Error

Reasoning: The provided code has a missing semicolon at the end of the line `result += c` in the `repeatChar` method, causing a syntax error. In Java, each statement should be terminated with a semicolon. 

Fix: Add a semicolon at the end of the line `result += c` in the `repeatChar` method.

Fixed Code:
```java
// Runtime: 0 ms (Top 98.7%) | Memory: 43.90 MB (Top 44.7%)

class Solution {
    public static int digiSum(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        return sum;
    }

    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += c;
        }
        return result;
    }

    public int differenceOfSum(int[] nums) {
        int eleSum = 0, digitSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            eleSum += nums[i];
            digitSum += Solution.digiSum(num);
        }
        return Math.abs(eleSum - digitSum);
    }
}
```