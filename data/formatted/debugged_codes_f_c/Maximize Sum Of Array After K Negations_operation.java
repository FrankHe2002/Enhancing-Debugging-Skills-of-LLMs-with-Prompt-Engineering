Bug Type: Syntax Error

Reasoning: The provided code is missing a semicolon (`;`) after the line `result += c`. Java requires each statement to end with a semicolon.

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