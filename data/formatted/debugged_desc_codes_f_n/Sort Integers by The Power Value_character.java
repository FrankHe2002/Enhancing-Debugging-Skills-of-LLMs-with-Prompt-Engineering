```java
import java.util.*;

class Solution {
    public int getKth(int lo, int hi, int k) {

        int n = hi - lo + 1;
        int[][] powerArr = new int[n][2];

        for (int i = lo, j = 0; i <= hi; i++)
            powerArr[j++] = new int[] {i, getPower(i)};

        Arrays.sort(powerArr, (a1, a2) -> a1[1] - a2[1] == 0 ? a1[0] - a2[0] : a1[1] - a2[1]);

        return powerArr[k - 1][0];
    }

    private int getPower(int i) {
        int power = 0;
        while(i != 1){
            if(i % 2 == 0) i /= 2;
            else i = 3 * i + 1;
            power++;
        }
        return power;
    }
}
```