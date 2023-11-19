Bug Type: Missing semicolon

Reasoning: On line 9, there is a missing semicolon at the end of the statement `result += c`. In Java, each statement must end with a semicolon. The absence of a semicolon causes a syntax error.

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