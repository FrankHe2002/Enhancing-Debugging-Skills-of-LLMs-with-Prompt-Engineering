The bug in the given code is that it is not correctly counting the number of rectangles that have the maximum side length.

To fix the bug, we can modify the code to check if the current side length is equal to the maximum side length instead of comparing the objects using the "==" operator. 

Here is the fixed code:

```java
import java.util.List;
import java.util.LinkedList;

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        List<Integer> list = new LinkedList<Integer>();
        int max = 0, count = 0;
        
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i][0] > rectangles[i][1]) {
                list.add(rectangles[i][1]);
                if (max < rectangles[i][1])
                    max = rectangles[i][1];
            } else {
                list.add(rectangles[i][0]);
                if (max < rectangles[i][0])
                    max = rectangles[i][0];
            }
        }
        
        for (Integer i : list) {
            if (i.equals(max))
                count++;
        }
        
        return count;
    }
}
```

In the fixed code, we have used the `equals()` method to compare the current side length `i` with the maximum side length `max`. This ensures that the comparison is made based on their values and not their object references.