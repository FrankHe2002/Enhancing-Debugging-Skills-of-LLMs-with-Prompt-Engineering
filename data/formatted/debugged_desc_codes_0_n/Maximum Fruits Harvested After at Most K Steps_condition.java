```java
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int posOfLastFruit = fruits[n - 1][0];
        int prefixArr[] = new int[posOfLastFruit + 1];

        for (int i = 0; i < n; i++) {
            prefixArr[fruits[i][0]] = fruits[i][1];
        }

        int minimum = prefixArr[startPos];
        prefixArr[startPos] = 0;

        int ans = 0;
        int start = Math.max(startPos - k, 0);

        for (int i = start; i < startPos; i++) {
            int maxCurrPossible = 0;
            int curr = 0;

            for (int j = i; j <= Math.min(startPos, i + k); j++) {
                curr += prefixArr[j];
                maxCurrPossible = Math.max(maxCurrPossible, curr);
            }
            ans = Math.max(ans, maxCurrPossible);
        }

        for (int i = startPos; i < posOfLastFruit; i++) {
            int maxCurrPossible = 0;
            int curr = 0;

            for (int j = i; j >= Math.max(startPos, i - k); j--) {
                curr += prefixArr[j];
                maxCurrPossible = Math.max(maxCurrPossible, curr);
            }
            ans = Math.max(ans, maxCurrPossible);
        }
        return ans + minimum;
    }
}
```