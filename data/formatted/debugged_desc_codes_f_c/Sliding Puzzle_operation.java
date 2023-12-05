Change `for (int i = 1; i <= nums.length; i++)` to `for (int i = 1; i < nums.length; i++)`:
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
}
```

Add semicolon at the end of the statement inside the loop:
```java
class Solution {
    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result += c;
        return result;
    }
}
```

Change `return a + b;` to `return a * b;`:
```java
class Solution {
    public int multiply(int a, int b) {
        return a * b;
    }
}
```

Change `return num % 2 == 1;` to `return num % 2 == 0;`:
```java
class Solution {
    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}
```

Change the condition `(year % 4 == 0) && (year % 100 != 0) || (year % 400 != 0)` to `(year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)`:
```java
class Solution {
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
```