Bug type: Logical error

The logical error is identified in the `preOrder` method. The `if (n != null) return;` statement should be `if (n == null) return;` to correctly check if the node is null before executing any further logic.

```java
void preOrder(Tree n, List<String> ans, Set<String> death) {
    if (n == null) return;
    if (!death.contains(n.name)) ans.add(n.name);
    for (Tree child : n.child) {
        preOrder(child, ans, death);
    }
}
```

In the `preOrder` method:
- If the current node is null, it should return immediately, as there are no further operations to be performed.
- The condition `if (!death.contains(n.name))` is correct, as it checks if the person is alive before adding them to the inheritance order list.
- The recursive call to `preOrder` is correctly traversing the tree to get the inheritance order.

These changes fix the logical error and correct the method's behavior.