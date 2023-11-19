Bug Type: Syntax Error

Reasoning: The buggy code contains a missing semicolon (`;`) at the end of the statement `result += c` in the method `repeatChar()`. Java requires each statement to end with a semicolon to indicate the end of the line.

Fix:
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