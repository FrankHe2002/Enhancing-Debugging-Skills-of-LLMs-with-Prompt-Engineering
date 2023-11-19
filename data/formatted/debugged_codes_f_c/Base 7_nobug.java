Bug Type: Missing character (`;`) in a `for` loop statement.

Reasoning: Looking at the provided code, there is a missing semicolon at the end of the statement inside the `for` loop. Java requires each statement to end with a semicolon, and the missing semicolon causes a syntax error.

Fix:
```java
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int temp = num;
        if (temp < 0) {
            temp = - temp;
        }
        while (temp > 0) {
            int rem = temp % 7;
            sb.append(rem);
            temp = temp / 7;
        }
        if (num < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
```