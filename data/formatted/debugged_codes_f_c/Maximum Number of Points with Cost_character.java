The bug in the provided code is a missing semicolon (`;`) at the end of the statement `result += c` in the `repeatChar` method. Adding a semicolon at the end of the statement will resolve the syntax error.

In addition, the buggy code does not have proper formatting and lacks comments for clarity. It is advised to format the code properly and providing comments to enhance understanding.

Fixed Code:
```java
class Solution {
    // findMax method
    public int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    // repeatChar method
    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += c;
        }
        return result;
    }

    // multiply method
    public int multiply(int a, int b) {
        return a * b;
    }

    // isEven method
    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    // isLeapYear method
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    // maxPoints method
    public long maxPoints(int[][] points) {
        long[] frame = new long[points[0].length];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < frame.length; j++)
                frame[j] += points[i][j];

            for (int j = 1; j < frame.length; j++)
                frame[j] = Math.max(frame[j], frame[j - 1] - 1);

            for (int j = frame.length - 2; j >= 0; j--)
                frame[j] = Math.max(frame[j], frame[j + 1] - 1);
        }

        long ans = 0;
        for (int i = 0; i < frame.length; i++) {
            ans = Math.max(ans, frame[i]);
        }
        return ans;
   