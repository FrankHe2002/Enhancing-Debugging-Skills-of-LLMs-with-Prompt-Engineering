There is a typo in the method signature for `maximumGood` where `int[][` should be replaced with `int[][]` (inside the `maximumGood` method):

```java
public int maximumGood(int[][] statements) {
    int[] result = {0};
    maximumGood(statements, new boolean[statements.length], 0, 0, result);
    return result[0];
}
```

After fixing the typo, the code should work as expected.