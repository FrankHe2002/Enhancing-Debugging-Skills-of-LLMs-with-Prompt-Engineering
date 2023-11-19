```java
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int L = points.length;
        int[] arr = new int[L];
        for (int i = 0; i < L; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);

        int diff = 0;

        for (int i = 1; i < L; i++) {
            diff = Math.max(diff, arr[i] - arr[i - 1]);
        }
        return diff;
    }
}
```