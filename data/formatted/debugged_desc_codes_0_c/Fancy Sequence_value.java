Bug type:
Logical Error

The bug is in the `multAll` method where the computation of the new value of the `add` array is incorrect. This is because the update for the `add` array is trying to access `add.get(l - 2)` which goes out of bounds.

Fix:
Update the computation of the new value of the `add` array in the `multAll` method.

```java
public void multAll(int m) {
    int l = add.size();
    add.set(l - 1, (add.get(l - 1) * m) % MOD);
    mult.set(l - 1, (mult.get(l - 1) * m) % MOD);
}
```