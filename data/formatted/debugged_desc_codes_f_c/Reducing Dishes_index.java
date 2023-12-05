The bug types are as follows:
- Example #1: Logical Error
- Example #2: Syntax Error
- Example #3: Logical Error
- Example #4: Logical Error
- Example #5: Logical Error

Explanation:
- Example #1: The bug is a logical error where the loop range causes an `ArrayIndexOutOfBoundsException` due to an incorrect condition `i <= nums.length`.
- Example #2: The bug is a syntax error caused by a missing semicolon at the end of the statement inside the loop.
- Example #3: The bug is a logical error caused by incorrect operation within the method, performing addition instead of multiplication.
- Example #4: The bug is a logical error where the method incorrectly checks for even numbers using the condition `num % 2 == 1`.
- Example #5: The bug is a logical error caused by an incorrect implementation of the leap year condition, including non-leap years erroneously.

Fix:
```java
// Example #1
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
}

// Example #2
class Solution {
    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result += c;
        return result;
    }
}

// Example #3
class Solution {
    public int multiply(int a, int b) {
        return a * b;
    }
}

// Example #4
class Solution {
    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}

// Example #5
class Solution {
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
```