The bug in the given Java code is the incorrect comparator in the PriorityQueue declaration. The comparator statement should use "->" instead of "%>".

Here's the fixed code with minimal changes:

```java
import java.util.PriorityQueue;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Apple> minHeap = new PriorityQueue<Apple>((a, b) -> (a.validDay - b.validDay)); // Fix: Changed the comparator symbol from "%>" to "->"

        // ... (rest of the code remains the same)
    }
}

class Apple {
    int count;
    int validDay;

    public Apple(int count, int validDay) {
        this.count = count;
        this.validDay = validDay;
    }
}
```