The bug in the code is in the while loop condition. The loop should run as long as the index is greater than or equal to 3, but currently, it runs as long as the index is less than 1 (which is always true because index starts at str.length() - 3). This results in an infinite loop.

To fix this, the condition in the while loop should be changed to `while (index >= 3)`.

Here is the corrected code:

```java
class Solution {
    public String thousandSeparator(int n) {

        StringBuffer str = new StringBuffer(Integer.toString(n));
        int index = str.length() - 3;

        while (index >= 3) {
            str.insert(index, '.');
            index = index - 3;
        }

        return str.toString();
    }
}
```