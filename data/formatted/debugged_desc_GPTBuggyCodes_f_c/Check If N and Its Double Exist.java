```java
import java.util.Arrays;

class Solution {
    public boolean checkIfExist(int[] arr) {
        int val1, val2;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            val1 = arr[i] * 2;
            int index = Arrays.binarySearch(arr, val1);
            if (index >= 0 && index != i) {
                return true;
            }
        }
        return false;
    }
}
```