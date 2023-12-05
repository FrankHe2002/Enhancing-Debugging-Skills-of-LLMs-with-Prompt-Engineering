The bug in the provided Java code is in Method 1. 
The bug is caused by the for loop condition for int i: for (int i = 0; i > rows; i++). The condition i > rows is incorrect and will result in the loop not being executed. The correct condition is i < rows.

To fix the bug, we need to change the condition i > rows to i < rows in the for loop.

Here's the corrected code:

```java
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] res = new int[rows * cols][2];

        int idx = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[idx][0] = i;
                res[idx][1] = j;
                idx++;
            }
        }

        Arrays.sort(res, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

            return d1 - d2;
        });

        return res;
    }
}
```