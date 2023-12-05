## Bug Fix

### Example #6:

- Bug Type: Syntax Error
- Error: Missing semicolon at the end of "result += c".
- Fix: Add a semicolon at the end of "result += c".

#### Bug Fix:


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