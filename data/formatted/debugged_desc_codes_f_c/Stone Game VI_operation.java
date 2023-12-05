Fix:
```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static class Pair {
        int ratio;
        int alice;
        int bob;

        public Pair(int ratio, int alice, int bob) {
            this.ratio = ratio;
            this.alice = alice;
            this.bob = bob;
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.ratio - p1.ratio;
            }
        });

        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceScore += pairs[i].alice;
            } else {
                bobScore += pairs[i].bob;
            }
        }

        if (aliceScore > bobScore) {
            return 1;
        } else if (aliceScore < bobScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
```