```java
// Runtime: 13 ms (Top 100.00%) | Memory: 70.5 MB (Top 87.78%)
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int L = points.length;
        // y-coordinate of a point does not matter in width
        int arr[] = new int[L];
        for (int i = 0; i < L; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        
        int diff = Integer.MIN_VALUE;

        for (int i = 0; i < L-1; i++) { // Fix range in loop condition
            if ((arr[i+1] - arr[i]) > diff) { // Fix index in array access
                diff = arr[i+1] - arr[i]; // Fix index in array access
            }
        }
        return diff;
    }
}
```