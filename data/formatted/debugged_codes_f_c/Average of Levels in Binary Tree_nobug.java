Bug Type: Missing semicolon

Reasoning: The bug in the provided code is a missing semicolon at the end of the line `result += c`.

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