Bug Type: Missing closing semicolon

After reviewing the code, I noticed that there is a missing closing semicolon at line 29, right after `result += c`. This missing semicolon causes a syntax error in the code.

To fix this bug, I will add a semicolon at the end of the statement in the loop.

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

Note: The rest of the code is not optimized or modified as it does not contain additional bugs apart from the missing semicolon.