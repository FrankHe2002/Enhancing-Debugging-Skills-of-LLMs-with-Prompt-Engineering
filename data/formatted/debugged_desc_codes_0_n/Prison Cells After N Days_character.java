```java
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = n % 14 == 0 ? 14 : n % 14;
        int temp[] = new int[cells.length];

        while (n-- > 0) {
            for (int i = 1; i < cells.length - 1; i++) {
                temp[i] = cells[i - 1] == cells[i + 1] ? 0 : 1;
            }
            cells = temp.clone();
        }

        return cells;
    }
}
```