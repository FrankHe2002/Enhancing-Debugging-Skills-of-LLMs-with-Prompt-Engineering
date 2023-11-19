The bug in the provided code is in the line:

```java
fiboArray[i] = fiboArrayi - 1] + fiboArray[i - 2];
```

There is a syntax error where `i` is missing the `[]` brackets. It should be:

```java
fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2];
```

To fix the bug, we just need to add the missing `[]` brackets to `fiboArray[i]` in the assignment statement.

Here's the fixed code:

```java
class Solution {
    public int fib(int n) {

        int[] fiboArray = new int[n + 2];

        fiboArray[0] = 0;
        fiboArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2];
        }

        return fiboArray[n];

    }
}
```

Now the code should work correctly without any syntax errors.