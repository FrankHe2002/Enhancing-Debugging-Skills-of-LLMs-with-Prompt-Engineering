The bug in the provided Java code is in the line where the cells array is assigned to the temp array. Clone method is used to copy the contents of the temp array to the cells array. However, in each iteration of the while loop, the cells array is being modified, so the previous changes are overwritten and the desired result is not achieved. 

To fix this bug, we need to move the creation of the temp array inside the while loop. This way, a new temp array will be created in each iteration, and the changes made in each iteration will not be overwritten.

Here is the fixed code:

```java
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = n % 14 == 0 ? 14 : n % 14;

        while (n-- > 0) {
            int temp[] = new int[cells.length];
            for (int i = 1; i < cells.length - 1; i++) {
                temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = temp;
        }

        return cells;
    }
}
```