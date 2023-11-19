Bug Type: Syntax Error

Reasoning: The code provided has a missing semicolon at line 17, which causes a syntax error. The statement `result += c` is not properly terminated.

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