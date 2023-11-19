Bug Type: Syntax Error

Reasoning: The code snippet is missing a semicolon at the end of the statement `result += c`.
The semicolon is required in Java to terminate statements.

Corrected Code:
```java
class Solution {
    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += c;
        }
        return result;
    }
}
```