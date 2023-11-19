Bug Type: Syntax Error

The provided code is missing a semicolon (`;`) at the end of the line `result += c`. This causes a syntax error in Java, as each statement should end with a semicolon.

To fix the code, we need to add the missing semicolon at the end of the statement inside the loop.

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