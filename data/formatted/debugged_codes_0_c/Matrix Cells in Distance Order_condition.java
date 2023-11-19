Based on the provided code, there is a bug in the for loop condition of the `allCellsDistOrder` method in Method 1.

```java
for (int i = 0; i > rows; i++) {
```

The condition `i > rows` is incorrect. The loop will only execute if `i` is greater than `rows`, which is not the intended behavior. It should be `i < rows` in order to loop through all the rows.

To fix this bug, we need to change the loop condition to `i < rows`.

```java
for (int i = 0; i < rows; i++) {
```

Here is the corrected code:
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

Note: Method 2 is commented out and does not have any bugs. So, no changes are required for it.