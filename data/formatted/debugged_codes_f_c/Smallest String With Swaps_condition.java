Bug Type: Missing semicolon

Explanation: The buggy code is missing a semicolon (;) at the end of the line `result += c`. In Java, each statement should end with a semicolon. The missing semicolon causes a syntax error.

Fix: Add a semicolon at the end of the statement `result += c`.

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