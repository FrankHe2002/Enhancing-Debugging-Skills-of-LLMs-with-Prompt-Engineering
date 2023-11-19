Bug Type: Syntax Error

Reasoning Process: In the provided code, there is a missing semicolon at the end of the statement `result += c` inside the `repeatChar` method. The code should have a semicolon after the statement for proper syntax.

Fix: Add a semicolon at the end of the statement `result += c` inside the `repeatChar` method.

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