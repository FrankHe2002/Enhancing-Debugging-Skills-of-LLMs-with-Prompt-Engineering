The bug in the provided Java code is in the `calcDis` method. Specifically, in the condition checks when adding elements to the queue.

```java
if (r + 1 < n && forest.get(r + 1).get(c) != 0) {
    queue.add(new int[] {r + 1, c});
    vis[r + 1][c] = true;
}
if (r - 1 >= 0 && forest.get(r - 1).get(c) != 0) {
    queue.add(new int[] {r - 1, c});
    vis[r - 1][c] = true;
}
if (c - 1 >= 0 && forest.get(r).get(c - 1) != 0) {
    queue.add(new int[] {r, c - 1});
    vis[r][c - 1] = true;
}
if (c + 1 < m && forest.get(r).get(c + 1) != 0) {
    queue.add(new int[] {r, c + 1});
    vis[r][c + 1] = true;
}
```

In the above code, there are two issues:

1. The condition `r + 1 < n && forest.get(r + 1).get(c) != 0` should be `r + 1 < n && forest.get(r + 1).get(c) != 0 && !vis[r + 1][c]`.
   This ensures that the position to be added to the queue hasn't been visited already.

2. The condition `r - 1 >= 0 && forest.get(r - 1).get(c) != 0` should be `r - 1 >= 0 && forest.get(r - 1).get(c) != 0 && !vis[r - 1][c]`.
   This ensures that the position to be added to the queue hasn't been visited already.

The fixed code looks like this:

```java
if (r + 1 < n && forest.get(r + 1).get(c) != 0 && !vis[r + 1][c]) {
    queue.add(new int[] {r + 1, c});
    vis[r + 1][c] = true;
}
if (r - 1 >= 0 && forest.get(r - 1).get(c) != 0 && !vis[r - 1][c]) {
