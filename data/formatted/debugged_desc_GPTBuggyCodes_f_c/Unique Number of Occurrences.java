The error in the provided `uniqueOccurrences` function lies in the way the count `c` is being checked and added to the HashSet. The code fails to check and add the count of the last element in the array and also misses adding the count 0 to the set.

Fix:
```java
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        int c = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) c++;
            else {
                if (set.contains(c)) return false;
                set.add(c);
                c = 1;
            }
        }
        if (set.contains(c)) return false;
        set.add(c); // Adding the count of the last element
        return true;
    }
}
```
After adding the line that includes `set.add(c);` after the loop, the function will properly identify if the number of occurrences of each value in the array is unique or not.