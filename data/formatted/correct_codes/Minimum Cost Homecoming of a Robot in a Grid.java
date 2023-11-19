class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int total = 0;
        if (homePos[0] > startPos[0]) {
            int i = startPos[0] + 1;
            while (i <= homePos[0]) {
                total += rowCosts[i];
                i++;
            }
        } else if (homePos[0] < startPos[0]) {
            int i = startPos[0] - 1;
            while (i >= homePos[0]) {
                total += rowCosts[i];
                i--;
            }
        }
        if (homePos[1] > startPos[1]) {
            int i = startPos[1] + 1;
            while (i <= homePos[1]) {
                total += colCosts[i];
                i++;
            }
        } else if (homePos[1] < startPos[1]) {
            int i = startPos[1] - 1;
            while (i >= homePos[1]) {
                total += colCosts[i];
                i--;
            }
        }

        return total;
    }
}

