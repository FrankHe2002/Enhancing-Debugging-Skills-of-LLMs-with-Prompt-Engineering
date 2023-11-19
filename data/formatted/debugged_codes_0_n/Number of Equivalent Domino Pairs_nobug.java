```java
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] pieces = new int[100];
        for (int[] domino : dominoes) {
            pieces[Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1])]++;
        }
        int pairs = 0;
        for (int i = 0; i <= 99; i++) {
            if (pieces[i] > 1) {
                pairs += getCombinations(pieces[i]);
            }
        }

        return pairs;
    }

    private int getCombinations(int n) {
        return (n * (n - 1)) / 2;
    }
}
```