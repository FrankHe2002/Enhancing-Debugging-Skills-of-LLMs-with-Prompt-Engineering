The bug in the provided Java code is in the constructor `MyHashSet()`. The code is creating an `ArrayList` of size 100, but the indices in the `ArrayList` range from 0 to 99 inclusive. So, when adding elements to the `ArrayList`, the range of indices should be 0 to `size - 1`.

To fix the bug, we need to change the for loop condition in the constructor to `i <= size` instead of `i < size`.

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
        return key % list.size();
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

The only change made was in the constructor, where the for loop condition was modified to `i < size`. This ensures that the `ArrayList` is created with the correct number of elements.