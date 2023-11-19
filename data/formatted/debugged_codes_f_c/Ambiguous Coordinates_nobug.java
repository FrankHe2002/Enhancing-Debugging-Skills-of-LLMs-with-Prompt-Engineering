Bug Type: Syntax Error

Reasoning: The provided code is missing a semicolon at the end of the line `result += c` in the `repeatChar` method. The missing semicolon causes a syntax error.

Fix: Add a semicolon at the end of the line `result += c`

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