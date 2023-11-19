Bug Type: Syntax Error

Reasoning: In the provided code, there is a missing semicolon at the end of the statement `result += c` inside the `repeatChar` method. Java requires each statement to end with a semicolon. Therefore, the missing semicolon results in a syntax error.

Fix: Add a semicolon at the end of the `result += c` statement.

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