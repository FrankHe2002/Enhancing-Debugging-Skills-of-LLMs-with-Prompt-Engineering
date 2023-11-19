Bug Type: Syntax Error

Explanation: The provided code has a syntax error due to a missing semicolon (`;`) after the statement `result += c` in the `repeatChar` method. 

Fix: Add a semicolon at the end of the statement `result += c`.

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