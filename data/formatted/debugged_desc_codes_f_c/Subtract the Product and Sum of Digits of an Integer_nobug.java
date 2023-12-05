The code looks good regarding the functionality.

The bug type is identified as a missing ```;``` semicolon at the end of the statement inside the loop at line 6. Adding a semicolon at the end of `result += c` corrects this syntax error.

The fixed code would be:
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