import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        while (n != 1) {
            int maxIndex = findIndex(arr, n);
            reverse(arr, maxIndex);
            reverse(arr, n - 1);
            list.add(maxIndex + 1);
            list.add(n);
            n--;
        }
        return list;
    }

    static int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return 0;
    }

    static void reverse(int[] arr, int maxIndex) {
        int l = 0, r = maxIndex;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}