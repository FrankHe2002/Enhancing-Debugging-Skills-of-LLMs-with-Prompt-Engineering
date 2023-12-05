```java
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNums = new ArrayList();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int row = 0; row < n; row++) {
            int min = matrix[row][0];
            int index = 0;
            boolean lucky = true;
            for (int col = 0; col < m; col++) {
                if (min > matrix[row][col]) {
                    min = matrix[row][col];
                    index = col;
                }
            }

            for (int r = 0; r < n; r++) {
                if (min < matrix[r][index]) {
                    lucky = false;
                    break;
                }
            }
            if (lucky) {
                luckyNums.add(min);
            }
        }
        return luckyNums;
    }
}
```