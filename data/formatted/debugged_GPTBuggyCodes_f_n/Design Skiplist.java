# Buggy Code:

```java
public boolean search(int target) {
    return this.find(target).key == target;
}
```

# Fixed Code:

```java
public boolean search(int target) {
    return this.find(target).value == target;
}
```