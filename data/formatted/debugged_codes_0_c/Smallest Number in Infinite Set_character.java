The bug in the provided Java code is in the `popSmallest()` method. 

Explanation:
1. The method starts with a check of the size of the `q` PriorityQueue. If the size is greater than 0, it means that there is at least one element in the priority queue, so the smallest element can be retrieved and returned using the `poll()` method.
2. In case the size of the priority queue is 0, the method should increment the `index` variable and return its value. This implies that consecutive calls to `popSmallest()` should return consecutive integer values starting from 1.
3. However, there is a missing closing bracket after the `return q.poll();` statement. As a result, the `return index++;` statement is never executed, and the method does not return the value of `index` when the priority queue is empty.

To fix this bug, we need to close the `if` statement before the `return index++;` statement.

Below is the corrected code:

```java
class SmallestInfiniteSet {
    private PriorityQueue<Integer> q;
    private int index;

    public SmallestInfiniteSet() {
        q = new PriorityQueue<Integer>();
        index = 1;
    }

    public int popSmallest() {
        if (q.size() > 0) {
            return q.poll();
        }
        
        return index++;
    }

    private boolean is_in_q(int num) {
        for (int i : q) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public void addBack(int num) {
        if (num < index && ! is_in_q(num)) {
            q.add(num);
        }
    }
}
```

Now the code will correctly return the value of `index++` when the priority queue is empty.