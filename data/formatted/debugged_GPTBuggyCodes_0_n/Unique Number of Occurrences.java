```java
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        
        // Fix bug by initializing 'c' as 1 instead of 0
        int c = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) c++;
            else {
                if (set.contains(c)) return false;
                set.add(c);
                c = 1;
            }
        }
        
        // Remove the check for 'c' in the set
        // This will fix the incorrect result
        return true;
    }
}
```