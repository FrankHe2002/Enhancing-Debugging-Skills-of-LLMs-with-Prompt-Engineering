Buggy Code:
```java
class Solution {
    public int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
```

Fixed Code:
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

Buggy Code:
```java
class Solution {
    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result += c
        return result;
    }
}
```

Fixed Code:
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

Buggy Code:
```java
class Solution {
    public int multiply(int a, int b) {
        return a + b;
    }
}
```

Fixed Code:
```java
class Solution {
    public int multiply(int a, int b) {
        return a * b;
    }
}
```

Buggy Code:
```java
class Solution {
    public boolean isEven(int num) {
        return num % 2 == 1;
    }
}
```

Fixed Code:
```java
class Solution {
    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}
```

Buggy Code:
```java
class Solution {
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 != 0)) {
            return true;
        }
        return false;
    }
}
```

Fixed Code:
```java
class Solution {
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
