import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        
        // Introduce a subtle bug by initializing 'c' as 0 instead of 1
        int c = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) c++;
            else {
                if (set.contains(c)) return false;
                set.add(c);
                c = 1;
            }
        }
        
        // Check if 'c' is already in the set without adding it 
        // This will cause incorrect results
        if (set.contains(c)) return false;
        
        return true;
    }
}