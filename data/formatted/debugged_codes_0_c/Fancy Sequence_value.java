Upon a quick review of the code, I noticed that the bug may be in the `multAll` method. 

In the `multAll` method, there is a line `add.set(l - 1, (add.get(l - 2) * m) % MOD);`. This line multiplies the last element in the `add` list with `m` and sets it as the new last element in the `add` list. 

However, this line accesses `add.get(l - 2)`, which is out of bounds if the size of `add` is 1. This means that the code will throw an `IndexOutOfBoundsException` if `multAll` is called before any calls to `append`.

To fix this bug, we can modify the `multAll` method to handle the edge case where the size of `add` is 1. We can simply set the new last element of `add` to `m` directly if the size of `add` is 1.

Here is the modified code:

```java
public void multAll(int m) {
    int l = add.size();
    if (l > 1) {
        add.set(l - 1, (add.get(l - 2) * m) % MOD);
    } else {
        add.set(0, m % MOD);
    }
    mult.set(l - 1, (mult.get(l - 1) * m) % MOD);
}
```