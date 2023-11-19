Bug Type: Missing semicolon

In the provided buggy code, there is a missing semicolon at the end of the line `result += c`. This results in a syntax error.

To fix this bug, we need to add a semicolon at the end of the statement to ensure correct syntax.

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