Bug Type: Syntax Error

Reasoning: The provided code has a missing semicolon at the end of the statement `result += c` in the `repeatChar` method. The code should end the statement with a semicolon to complete the syntax.

Fix:

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