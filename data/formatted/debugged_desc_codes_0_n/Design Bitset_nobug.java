```java
import java.util.*;

class Bitset {
    int size;
    Set<Integer> one = new HashSet<>();
    Set<Integer> zero = new HashSet<>();

    public Bitset(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) zero.add(i);
    }

    public void fix(int idx) {
        if (zero.contains(idx)) {
            one.add(idx);
            zero.remove(idx);
        }
    }

    public void unfix(int idx) {
        if (one.contains(idx)) {
            zero.add(idx);
            one.remove(idx);
        }
    }

    public void flip() {
        Set<Integer> s = one;
        one = zero;
        zero = s;
    }

    public boolean all() {
        return one.size() == size;
    }

    public boolean one() {
        return !one.isEmpty();
    }

    public int count() {
        return one.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (one.contains(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}
```