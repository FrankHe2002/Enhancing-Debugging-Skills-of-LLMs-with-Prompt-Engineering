The bug type in the provided Java code is an IndexOutofBoundsException which occurs when the index of any array is out of its bound value. 

Fix:

```java
import java.util.Arrays;

class Solution {
    public long minimumRemoval(int[] beans) {
       Arrays.parallelSort(beans);
        long sum = 0;
        int n  = beans.length;
        long min = Long.MAX_VALUE;
        for(int i: beans)
            sum += i;
        for(int i=0; i<n-1; i++ ){
            long temp = sum - (long) (n-i)*(long) beans[i];
            min = Math.min(min, temp);
        }
        return min;
    }
}
```