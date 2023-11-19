The bug in the provided code is in the check for unique occurrences. The code is incorrectly checking whether the set contains the count variable `c` instead of the actual value in the array `arr[i]`. 

To fix the bug, we need to change the line `set.contains(c)` to `set.contains(arr[i])`.

Here's the fixed code:

```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();

        int c = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                c++;
            else {
                if (set.contains(arr[i]))
                    return false;
                set.add(arr[i]);
                c = 1;
            }
        }
        
        if (set.contains(arr[arr.length - 1]))
            return false;
        
        return true;
    }
}
```

Now, the code correctly checks for unique occurrences of values in the array.