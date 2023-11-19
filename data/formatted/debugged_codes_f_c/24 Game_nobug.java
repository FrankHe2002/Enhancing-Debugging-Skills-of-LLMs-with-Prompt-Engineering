Bug Type: Syntax Error

Reasoning: The code is missing a semicolon (`;`) at the end of the statement `result += c`. This causes a syntax error.

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