The bug in the provided code is a syntax error in the method signature. The opening and closing parentheses are missing from the method declaration.

To fix the bug, we need to add the opening and closing parentheses after the return type `int[]`.

Here is the fixed code:

```java
// Runtime: 2 ms (Top 67.33%) | Memory: 55.1 MB (Top 5.58%)
class Solution {
    public int[] replaceElements(int[] arr) {
        int greatElement = - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = greatElement;
            greatElement = Math.max(temp, greatElement);
        }
        return arr;
    }
}
```