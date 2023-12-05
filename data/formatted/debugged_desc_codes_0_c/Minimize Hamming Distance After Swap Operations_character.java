Bug: There is a bug in the UnionFind class where the components variable is not properly initialized.

Fix:
Initialize the components variable in the UnionFind constructor.

Code:
```java
UnionFind(int n) {
        if (n <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");
        size = n;
        components = n; // Add missing semicolon
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
```