There is a bug in the `MyHashSet` class's constructor when initializing the ArrayList. The size of the ArrayList is set to `size`, but the actual initialization only adds `size - 1` elements.

To fix this bug, the size of the ArrayList should be set to `size + 1` because the size of the ArrayList should match the value of `size` provided in the constructor. 

Here's the modified code:

```java
import java.util.ArrayList;
import java.util.LinkedList;

class MyHashSet {
    ArrayList<LinkedList<Integer>> list;
    int size = 100;

    public MyHashSet() {
        list = new ArrayList<>(size + 1);
        for (int i = 0; i < size; i++) {
            list.add(new LinkedList<Integer>());
        }
    }

    public int hash(int key) {
        return key % list.size();
    }

    public int search(int key) {
        int i = hash(key);

        LinkedList<Integer> temp = list.get(i);
        int ans = -1;

        for (int j = 0; j < temp.size(); j++) {
            if (key == temp.get(j)) {
                return j;
            }
        }
        return ans;
    }

    public void add(int key) {
        if (search(key) == -1) {
            int i = hash(key);
            list.get(i).add(key);
        }
    }

    public void remove(int key) {
        if (search(key) != -1) {
            int i = hash(key);
            list.get(i).remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        return search(key) != -1;
    }
}
```