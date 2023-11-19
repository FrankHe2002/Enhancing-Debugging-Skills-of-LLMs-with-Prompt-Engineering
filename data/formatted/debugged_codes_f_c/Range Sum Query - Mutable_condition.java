Bug Type: Syntax Error

Reasoning: In the provided code, there is a missing semicolon at the end of the statement `result += c` in the `repeatChar` method. Java requires each statement to end with a semicolon. To fix this bug, we need to add a semicolon at the end of the statement.

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