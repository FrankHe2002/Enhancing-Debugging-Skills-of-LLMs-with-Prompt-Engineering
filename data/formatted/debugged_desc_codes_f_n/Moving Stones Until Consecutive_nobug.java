```java
// Runtime: 2 ms (Top 43.75%) | Memory: 41.9 MB (Top 57.50%)
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        int minimum = findMinimum(arr);
        int maximum = findMaximum(arr);
        return new int[] {minimum, maximum};
    }

    public int findMaximum(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        if (arr[0] == (arr[1] - 1) && arr[1] == (arr[2] - 1)) return count;
        if (arr[0] == arr[1] - 1) {
            arr[2]--;
            count++;
        } else {
            arr[0]++;
            count++;
        }
        return count + findMaximum(arr);

    }

    public int findMinimum(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] == arr[1] - 2 || arr[1] == arr[2] - 2 || (arr[0] == arr[1] - 1 && arr[1] == arr[2] - 2)) {
            return 1;
        }
        return 2;
    }
}
```