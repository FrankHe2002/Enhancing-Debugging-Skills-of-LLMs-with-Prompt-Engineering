```java
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }
        int count = 0;
        for (int i = 0; i < n; i += 2) {
            int couple = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            if (row[i + 1] != couple) {
                int tmp = row[i + 1];
                row[i + 1] = couple;
                row[pos[couple]] = tmp;
                pos[tmp] = pos[couple];
                count++;
            }
        }
        return count;
    }
}
```