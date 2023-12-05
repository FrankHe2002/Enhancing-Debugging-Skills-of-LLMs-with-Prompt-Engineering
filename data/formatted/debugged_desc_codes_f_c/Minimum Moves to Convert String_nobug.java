The bug type in the provided project is a logical error.
The original code performs a substraction in the isLeapYear method when we should use the logical operators.

The fixed code has been provided below:
```java
class Solution {
    public int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result += c;
        return result;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public int minimumMoves(String s) {
        int i = 0;
        int step = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                i = i + 3;
                step++;
            } else {
                i++;
            }
        }
        return step;
    }
}
```