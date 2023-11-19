Bug Type: Syntax Error

Reasoning: The code has a syntax error in the line `result += c` in the `repeatChar` method. The line is missing a semicolon at the end of the statement.

Fix: Add a semicolon at the end of the statement `result += c;`.

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