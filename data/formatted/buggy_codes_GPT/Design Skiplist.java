    public boolean search(int target) {
        return this.find(target).key == target;
    }
```
Instead of `return this.find(target).key == target;`, change it to `return this.find(target).value == target;`.
