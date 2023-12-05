The bug in this code is in the while loop condition. The current condition `while (index < 1)` should be `while (index > 0)` to correctly insert the dot as a thousand separator. 

Additionally, the index should be updated inside the loop as well. The line `index = index - 3;` should update the index to `index -= 3;`.

The fixed code looks like this:

```java
class Solution {
    public String thousandSeparator(int n) {

        StringBuffer str = new StringBuffer(Integer.toString(n));
        int index = str.length() - 3;

        while (index > 0) {
            str.insert(index, '.');
            index -= 3;
        }

        return str.toString();
    }
}
```