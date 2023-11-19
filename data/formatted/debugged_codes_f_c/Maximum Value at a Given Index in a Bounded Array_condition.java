Bug Type: Syntax Error

Bug Explanation: The code is missing a semicolon at the end of the statement inside the for loop.

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