There is a bug in the code which causes problems with the breadth-first search. Let's look into the calcDis function to identify the bug.

The bug is in the conditional statement in the calcDis function:

```java
if (r + 1 < n && ! vis[r + 1][c + 2] && forest.get(r + 1).get(c) != 0) {
    queue.add(new int[] {r + 1, c});
    vis[r + 1][c] = true;
}
```

There's a typo in `c + 2`, it should be `c + 1`. The array access expression `vis[r + 1][c + 2]` is indexing outside the bounds of the array.

Here's the updated code with the fix:

```java
if (r + 1 < n && ! vis[r + 1][c] && forest.get(r + 1).get(c) != 0) {
    queue.add(new int[] {r + 1, c});
    vis[r + 1][c] = true;
}
```

After fixing the conditional statement, the code should work correctly without the risk of indexing outside the array.