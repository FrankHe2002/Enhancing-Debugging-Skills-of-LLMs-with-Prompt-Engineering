Bug Type: Syntax Error

Reasoning: In the provided code, there is a missing semicolon (`;`) on line 13. The statement `result += c` should end with a semicolon to terminate the statement. This missing semicolon results in a syntax error.

Fix: Add a semicolon at the end of the statement `result += c`.

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