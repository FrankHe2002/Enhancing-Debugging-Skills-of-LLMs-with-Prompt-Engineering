The bug in the provided Java code is a syntax error in the line `c[i - 1][Runtime]++`. The correct index should be `1` instead of `Runtime`.

To fix this bug, we need to change `Runtime` to `1` in both occurrences.

Here is the fixed code:

```java
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int[][] c = new int[6][2];

        for (int i : tops) {
            c[i - 1][0]++;
        }
        for (int i : bottoms) {
            c[i - 1][1]++;
        }
        int[] common = new int[6];
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == bottoms[i]) {
                common[tops[i] - 1]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            if (c[i - 1][0] + c[i - 1][1] >= tops.length) {
                if (c[i - 1][0] >= c[i - 1][1] && c[i - 1][1] - common[i - 1] + c[i - 1][0] == tops.length) {
                    min = Math.min(min, c[i - 1][1] - common[i - 1]);
                } else if (c[i - 1][1] >= c[i - 1][0] && c[i - 1][0] - common[i - 1] + c[i - 1][1] == tops.length) {
                    int left = c[i - 1][0] - common[i - 1];
                    min = Math.min(min, c[i - 1][0] - common[i - 1]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? - 1 : min;
    }
}
```