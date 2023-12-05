````java
import java.util.Arrays;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int maximum = findMaximum(arr);
        int minimum = findMinimum(maximum, arr);
        return new int[] {minimum, maximum};
    }

    public int findMaximum(int[] arr) {
        if (arr[0] == (arr[1] - 1) && arr[1] == (arr[2] - 1)) return 0;
        if (arr[0] == arr[1] - 1) {
            arr[2]--;
        } else {
            arr[0]++;
        }
        return 1 + findMaximum(arr);
    }

    public int findMinimum(int max, int[] arr) {
        if (max == 0) return 0;
        else if (arr[1] <= arr[0] + 2 || arr[2] <= arr[1] + 2) return 1;
        else return 2;
    }
}
````