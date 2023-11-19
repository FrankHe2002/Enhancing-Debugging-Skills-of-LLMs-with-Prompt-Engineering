Bug Type: Misspelling

Line 29: public void bfs(int key, boolean[] vivsted, int target, List<List<Integer>> rooms) 

There is a misspelling in the parameter name "vivsted". It should be "visited" to match the variable name used in the rest of the code.

To fix the bug, change "vivsted" to "visited" in the bfs() method signature:

```java
public void bfs(int key, boolean[] visited, int target, List<List<Integer>> rooms) {
```

Note: This fix does not require any additional changes to the code, as the misspelled variable name is not used anywhere else.