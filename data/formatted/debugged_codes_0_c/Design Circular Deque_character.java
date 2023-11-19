## Bug

There is a compilation error in the code. The error is in the `deleteLast` method where there is a missing closing parenthesis on the `dq.pop_back()` line.

## Fix

Add a closing parenthesis on the `dq.pop_back()` line in the `deleteLast` method.

```java
bool deleteLast() {
    if (dq.size() > 0) {
        dq.pop_back();
        return true;
    }
    return false;
}
```

Alternatively, the code can be fixed by adding a closing parenthesis on the `dq.pop_back();` line in the original code.