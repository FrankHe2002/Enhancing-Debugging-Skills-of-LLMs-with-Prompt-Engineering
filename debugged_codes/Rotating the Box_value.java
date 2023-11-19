 class Solution {
     public char[][] rotateTheBox(char[][] box) {
         int row = box.length, col = box[0].length;
         char[][] res = new char[col][row];
         // rotate first, then drop
         for (int i = -1; i < row - 1; i++) {
             for (int j = 0; j < col; j++) {
                 res[j][i+1] = box[row-1-i][j];
             }
         }

        for (int i = col - 1; i >= 0; i--) {
             for (int j = 0; j < row; j++) {
                 if (res[i][j] == '#') {
                     int curRow = i;
                     while (curRow+1 < col && res[curRow+1][j] == '.') {
                         curRow++;
                     }
                     if (curRow != i) {
                         res[curRow][j] = '#';
                         res[i][j] = '.';
                     }
                 }
             }
         }
         return res;
     }
 }