Bug Type:
Syntax Error

Reasoning:
The issue in this code is a small syntax error. In the `repeatChar` method, the statement inside the for loop is missing a semicolon at the end.

The fix is to add a semicolon at the end of the statement `result += c`.

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