```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);

        if (changed.length % 2 != 0) {
            return new int[0];
        }

        int mid = changed.length / 2;
        int[] res = new int[mid];
        Map<Integer, Integer> freq = new HashMap<>();

        for (int no : changed) {
            freq.put(no, freq.getOrDefault(no, 0) + 1);
        }

        int idx = 0;
        for (int no : changed) {
            if (freq.get(no) > 0 && no * 2 < 100000 && freq.getOrDefault(no * 2, 0) > 0) {
                freq.put(no, freq.get(no) - 1);
                freq.put(no * 2, freq.get(no * 2) - 1);
                res[idx++] = no;
            }
        }

        for (int i = 0; i < freq.size(); i++) {
            if (freq.getOrDefault(i, 0) != 0) {
                return new int[0];
            }
        }

        return res;
    }
}
```