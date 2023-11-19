```java
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int sLen = s.length();
        int[] numberOfPlates = new int[sLen + 1];
        for (int i = 0; i < sLen; i++) {
            numberOfPlates[i + 1] = numberOfPlates[i] + (s.charAt(i) == '*' ? 1 : 0);
        }
        int[] candleToTheLeft = new int[sLen];
        int cand = -1;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == '|') {
                cand = i;
            }
            candleToTheLeft[i] = cand;
        }
        int[] candleToTheRight = new int[sLen];
        cand = -1;
        for (int i = sLen - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                cand = i;
            }
            candleToTheRight[i] = cand;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = candleToTheLeft[queries[i][0]];
            int right = candleToTheRight[queries[i][1]];
            if (left == -1 || right == -1 || left >= right) {
                res[i] = 0;
            } else {
                res[i] = numberOfPlates[right + 1] - numberOfPlates[left + 1];
            }
        }
        return res;
    }
}
```