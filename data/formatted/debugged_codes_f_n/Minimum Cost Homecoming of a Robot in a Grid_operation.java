## Bug Fix:
```java
class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int total = 0;

        // if home is below start position, move down till there
        if (homePos[0] > startPos[0]) {
            int i = startPos[0] + 1;
            while (i <= homePos[0]) {
                total += rowCosts[i]; // add cost while moving corresponding to the cell
                i++;
            }
        }

        // else if home is above start position, move up till there
        else if (homePos[0] < startPos[0]) {
            int i = startPos[0] - 1;
            while (i >= homePos[0]) {
                total += rowCosts[i]; // add cost while moving corresponding to the cell
                i--;
            }
        }

        // if home is right to the start, move right till there
        if (homePos[1] > startPos[1]) {
            int i = startPos[1] + 1;
            while (i <= homePos[1]) {
                total += colCosts[i];  // add cost while moving corresponding to the cell
                i++;
            }
        }

        // else if home is left to the start, move left till there
        else if (homePos[1] < startPos[1]) {
            int i = startPos[1] - 1;
            while (i >= homePos[1]) {
                total += colCosts[i];  // add cost while moving corresponding to the cell
                i--;
            }
        }

        return total;
    }
}
```