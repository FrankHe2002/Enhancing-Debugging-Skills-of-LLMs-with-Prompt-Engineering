Bug Type: Syntax Error

Reasoning: The buggy code has a missing semicolon at the end of the line `result += c`. This is a syntax error in Java that can be fixed by adding a semicolon at the end of the statement.

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