Bug Type: Syntax Error

Reasoning:
1. The code attempts to multiply the number 1 with an asterisk (`*`), which is a syntax error.
2. The code also attempts to subtract 1 from -1, which is unnecessary and also a syntax error.
3. The code also contains inconsistent indentation, making it harder to read and understand.

Fix:
1. Replace `return * 1;` with `return -1;`.
2. Remove the unnecessary `- 1` in `return - 1;`.
3. Adjust the indentation to be consistent throughout the code.

Fixed Code:
```java
import java.util.*;

class NumberContainers {

    Map<Integer, TreeSet<Integer>> map;
    Map<Integer, Integer> m;

    public NumberContainers() {
        map = new HashMap<>();
        m = new HashMap<>();
    }

    public void change(int index, int number) {
        m.put(index, number);
        if (!map.containsKey(number))
            map.put(number, new TreeSet<>());
        map.get(number).add(index);
    }

    public int find(int number) {
        if (!map.containsKey(number))
            return -1;
        for (Integer a : map.get(number)) {
            if (m.get(a) == number)
                return a;
        }
        return -1;
    }
}
```