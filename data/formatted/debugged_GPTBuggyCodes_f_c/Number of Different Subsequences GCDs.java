Bug Type: Missing Semicolon

Reasoning: In the buggy code, there is a missing semicolon at the end of the line `result += c` in the `repeatChar` method. This causes a syntax error and prevents the code from compiling.

Fix:

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