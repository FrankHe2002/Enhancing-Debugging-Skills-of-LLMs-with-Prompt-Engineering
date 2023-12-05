The bug in the given code is in the checkIfExist method where the binary search algorithm is incorrectly implemented to find the double of each element in the array. Also, there is an unnecessary private sort method in the class Solution.

To fix the bug, the binary search algorithm has to be removed and replaced with a simple linear search to find the value that is twice the current element. Additionally, the private sort method should be removed as it is not being used.

Here's the corrected code:

```java
import java.util.Arrays;

class Solution {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int val1 = arr[i];
            int val2 = val1 * 2;

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[j] == val2) {
                    return true;
                }
            }
        }
        return false;
    }
}
```