```java
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] c = new int[7][2];

        for (int i = 0; i < tops.length; i++) {
            c[tops[i]][0]++;
            c[bottoms[i]][1]++;
        }
        
        int[] common = new int[7];
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == bottoms[i]) {
                common[tops[i]]++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            if (c[i][0] + c[i][1] >= tops.length) {
                if (c[i][0] >= c[i][1] && c[i][1] - common[i] + c[i][0] == tops.length) {
                    min = Math.min(min, c[i][1] - common[i]);
                } else if (c[i][1] >= c[i][0] && c[i][0] - common[i] + c[i][1] == tops.length) {
                    min = Math.min(min, c[i][0] - common[i]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
```