The code looks logically correct and there is a good approach to solve the given problem using Breadth First Search (BFS). 

Upon inspecting the code, there is a potential bug in the `isInsideGrid` method. The condition for checking if `col` is valid is incorrect.

Here's the corrected `isInsideGrid` method:

```java
private boolean isInsideGrid(int row, int col) {
    return row >= 0 && row < rows && col >= 0 && col < cols;
}
```

The corrected condition is `col >= 0` instead of `col < 0`.

This correction will fix the bug and ensure that the code functions as expected.