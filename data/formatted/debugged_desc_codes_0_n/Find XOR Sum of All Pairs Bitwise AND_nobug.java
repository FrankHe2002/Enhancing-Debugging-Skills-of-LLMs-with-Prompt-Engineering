```java
// Runtime: 1 ms (Top 99.58%) | Memory: 38.6 MB (Top 72.48%)
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int[] x = (arr1.length < arr2.length ? arr2 : arr1);
        int[] y = (arr1.length < arr2.length ? arr1 : arr2);
        int xorSumX = 0;
        for (int xi : x) {
            xorSumX ^= xi;
        }
        int answer = xorSumX & y[0];
        for (int i = 1; i < y.length; i++) {
            answer ^= (y[i] & xorSumX);
        }
        return answer;
    }
}
```