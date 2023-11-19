Bug Type: Syntax Error

Bug Reasoning:
1. The code has a syntax error due to a missing semicolon (;) in line 14 of the provided code: `result += c`
2. In Java, each statement must end with a semicolon.

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