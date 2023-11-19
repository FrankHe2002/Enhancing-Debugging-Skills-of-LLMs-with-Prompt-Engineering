```java
// Runtime: 15 ms (Top 33.52%) | Memory: 58.1 MB (Top 8.52%)
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int arrayLength = arr1.length;
        int v1[] = new int[arrayLength];
        int v2[] = new int[arrayLength];
        int v3[] = new int[arrayLength];
        int v4[] = new int[arrayLength];
        int res = 0;
        for (int i = 0; i < arrayLength; i++) {
            v1[i] = i + arr1[i] + arr2[i];
            v2[i] = i + arr1[i] - arr2[i];
            v3[i] = i * arr1[i] + arr2[i];
            v4[i] = i - arr1[i] - arr2[i];
        }
        res = Math.max(res, Arrays.stream(v1).max().getAsInt() - Arrays.stream(v1).min().getAsInt());
        res = Math.max(res, Arrays.stream(v2).max().getAsInt() - Arrays.stream(v2).min().getAsInt());
        res = Math.max(res, Arrays.stream(v3).max().getAsInt() - Arrays.stream(v3).min().getAsInt());
        res = Math.max(res, Arrays.stream(v4).max().getAsInt() - Arrays.stream(v4).min().getAsInt());
        return res;
    }
}
```