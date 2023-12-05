Bug type: Logical error

Errors:
1. There is a typo in the variable name `evalvars[b]` should be `evalvars[i]`.
2. The `getNext` method is not handling the negative numbers.

Fixing the bugs:

1. Replace `evalvars[b]` with `evalvars[i]`.
2. Update the `getNext` method to consider the negative numbers.

```java
        for (int i = 0; i < evalvars.length; i++) {
            vars.put(evalvars[i], evalints[i]);
        }

...

    int getNext(String expression, int start) {
        int end = start;
        if (expression.charAt(start) == '-') {
            start++;
            end++;
        }
        while (end < expression.length() && Character.isLetterOrDigit(expression.charAt(end))) {
            end++;
        }
        return end - 1;
    }
```