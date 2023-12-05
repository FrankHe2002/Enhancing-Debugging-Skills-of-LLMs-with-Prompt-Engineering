Corrected code:

```java
import java.util.HashMap;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> hm = new HashMap<>();
        for (int[] piece : pieces) {
            hm.put(piece[0], piece);
        }

        int index = 0;
        while (index < arr.length) {
            if (!hm.containsKey(arr[index])) {
                return false;
            }

            int[] piece = hm.get(arr[index]);
            for (int val : piece) {
                if (index >= arr.length || val != arr[index]) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }
}
```