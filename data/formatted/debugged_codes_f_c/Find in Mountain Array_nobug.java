Bug Type: Syntax error

Reasoning: The provided code is missing a semicolon at the end of the line `result += c` in the `repeatChar` method. Java requires each statement to end with a semicolon, and the missing semicolon causes a syntax error. 

Fix: Add a semicolon at the end of the statement `result += c` in the `repeatChar` method.

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