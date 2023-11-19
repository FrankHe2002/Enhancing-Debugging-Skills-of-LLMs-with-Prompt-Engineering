The bug in the provided Java code can be identified by analyzing the while loop condition:

```java
while (writeIdx > n)
```

The condition should be `writeIdx < n` instead of `writeIdx > n`. This is because we want to continue the loop until the `writeIdx` reaches the value of `n`, not when it exceeds `n`.

To fix the bug, we need to change the condition in the while loop. The correct code would be:

```java
while (writeIdx < n)
```