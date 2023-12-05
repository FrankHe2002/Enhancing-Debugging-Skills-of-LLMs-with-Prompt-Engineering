```java
class Solution {
    Integer[][] min;

    public int calculateMinimumHP(int[][] dungeon) {
        min = new Integer[dungeon.length][dungeon[0].length];
        int answer = min(0, 0, dungeon);
        return Math.max(answer, 1);
    }

    public int min(int i, int j, int[][] dungeon) {
        if (i == dungeon.length || j == dungeon[0].length) return 400000;
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1) return Math.max(1, -dungeon[i][j] + 1);
        if (min[i][j] == null) {
            int down = min(i + 1, j, dungeon);
            int right = min(i, j + 1, dungeon);
            min[i][j] = Math.max(Math.min(right, down) - dungeon[i][j], 1);
        }
        return min[i][j];
    }
}
```