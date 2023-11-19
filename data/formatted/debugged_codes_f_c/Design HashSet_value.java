The bug in the provided code is that the hashing function `hash(int key)` is using the wrong size for calculating the hash. Instead of `list.size()`, it should be `size`. 

To fix this bug, we need to change the line `return key % list.size();` to `return key % size;` in the `hash(int key)` method.

Here is the fixed code:

```java
import java.util.ArrayList;
import java.util.LinkedList;

class MyHashSet {
    ArrayList<LinkedList<Integer>> list;
    int size = 100;

    public MyHashSet() {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new LinkedList<Integer>());
        }
    }

    public int hash(int key) {
        return key % size;
    }

    public int search(int key) {
        int i = hash(key);

        LinkedList<Integer> temp = list.get(i);
        int ans = - 1;

        for (int j = 0; j < temp.size(); j++) {
            if (key == temp.get(j)) {
                return j;
            }
        }
        return ans;
    }

    public void add(int key) {
        if (search(key) == - 1) {
            int i = hash(key);
            list.get(i).add(key);
        }
    }

    public void remove(int key) {
        if (search(key) != - 1) {
            int i = hash(key);
            list.get(i).remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        return search(key) != - 1;
    }
}
```