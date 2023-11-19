Bug Type: Missing semicolon

Reasoning: The buggy code is missing a semicolon after the line `result += c`. In Java, each statement must end with a semicolon, and the absence of it results in a syntax error.

Fixed Code:

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