Bug Type: Missing semicolon

Reasoning: The error in the provided code is a missing semicolon at the end of the statement `result += c` in the `repeatChar` method. Adding a semicolon at the end of the statement will fix this issue.

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