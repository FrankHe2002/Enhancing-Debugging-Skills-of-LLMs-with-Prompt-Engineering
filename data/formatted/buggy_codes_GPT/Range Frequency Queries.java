
```
tree.put(i, tree.size());
```

should be changed to:

```
tree.put(i, tree.size() + 1);
```