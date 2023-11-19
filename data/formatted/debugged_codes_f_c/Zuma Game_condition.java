Bug Type: Syntax Error

Reasoning:
1. The code is missing a semicolon at the end of the statement `result += c` inside the `repeatChar` method.
2. In Java, each statement must end with a semicolon to indicate the end of the statement.

Fix:
Add a semicolon at the end of the statement `result += c` to correct the syntax error.

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