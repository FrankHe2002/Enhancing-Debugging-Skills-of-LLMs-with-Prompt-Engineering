The provided Java code seems to be well-structured and based on the tail-swap algorithm for the flip operation. However, there are a couple of issues that need to be addressed:

1. In the `flip()` method, the code checks if `size < 0` to return {-1, -1}, but this check is incorrect. The condition should be `if (size <= 0)` to handle the cases where `size` becomes 0 after sequential flipping. Additionally, it may be better to throw an exception in this case to indicate a logical error rather than silently returning a special index value.

2. In the `reset()` method, while resetting the `map`, the code should call `clear()` on the map instead of reassigning a new `HashMap` to the `map` variable.

Here’s the modified code with the fixes applied:

```java
import java.util.*;

// Runtime: 45 ms (Top 62.26%) | Memory: 50.7 MB (Top 63.21%)
// Swap Tail Element Solution
// 1. Get a random number between [0, size-1]
// 2. size - 1
// 3. Get the index in map by the random map
// 4. Update the flipped element with the tail element.
// Time complexity: O(1) to init, flip, and reset
// Space complexity: O(K), where K is the times of flip calls.
class Solution {
    private final int M, N, CAPACITY;
    private int size;
    private Random random;
    private Map<Integer, Integer> map;

    public Solution(int m, int n) {
        M = m;
        N = n;
        CAPACITY = m * n;
        size = CAPACITY;
        random = new Random();
        map = new HashMap<>();
    }

    public int[] flip() {
        if (size <= 0) throw new IllegalStateException("No more free cells available."); // Throw an exception if no more cells are available
        Integer rand = random.nextInt(size);
        size--;
        int idx = map.getOrDefault(rand, rand);
        Integer tail = map.getOrDefault(size, size);
        map.put(rand, tail);
        return new int[] {idx / N, idx % N};
    }

    public void reset() {
        map.clear(); // Clear the content of the map
        size = CAPACITY;
    }
}
```

With these changes, the code should function correctly and handle edge cases where no more free cells are available or when resetting the matrix.