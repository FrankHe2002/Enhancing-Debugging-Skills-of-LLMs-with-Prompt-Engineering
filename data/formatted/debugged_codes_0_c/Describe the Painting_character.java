Bug type: Syntax error

The code seems to have a missing semicolon on line 61. The line `Long prevColor = res.get(len - 1).get(2)` is missing a closing semicolon, which results in a syntax error.

To fix the bug, add a semicolon at the end of line 61:

```java
Long prevColor = res.get(len - 1).get(2);
```