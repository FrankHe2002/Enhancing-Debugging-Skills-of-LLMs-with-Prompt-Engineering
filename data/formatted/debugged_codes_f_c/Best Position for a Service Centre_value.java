Bug Type: Syntax Error

Reasoning:
1. The code does not compile because there is a missing semicolon at line 14. 
2. The line `result += c` should end with a semicolon to indicate the end of the statement.

Fix:
Add a semicolon at the end of line 14.

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