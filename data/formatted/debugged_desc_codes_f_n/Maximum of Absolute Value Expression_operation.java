```java
// Runtime: 15 ms (Top 33.52%) | Memory: 58.1 MB (Top 8.52%)
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        //1. remove the modulas -
        //i & j are interchangable because they are inside the modulas
        // A[i] - A[j] + B[i] -B[j] + i-j
        // A[i] + B[i] + i - B[j] - A[j] - j
        // (A[i] + B[i] + i) ->X
        // (B[j] - A[j] - j) -> y
        // X - Y;
        //to get max value X should be max & Y should min

        // Possible cases (Since both arrays have same number of indexes, we can use single for loop & i as index)
        //A[i] + B[i] + i ->1
        //A[i] - B[i] + i ->2
        //A[i] + B[i] - i ->3
        //A[i] - B[i] - i ->4

        // Find out max of all response

        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            int case1 = i + arr1[i] + arr2[i];
            int case2 = i + arr1[i] - arr2[i];
            int case3 = i - arr1[i] + arr2[i];
            int case4 = i - arr1[i] - arr2[i];
            int respA = Math.max(Math.max(case1, case2), Math.max(case3, case4)) - Math.min(Math.min(case1, case2), Math.min(case3, case4));
            res = Math.max(res, respA);
        }
        return res;
    }
}
```