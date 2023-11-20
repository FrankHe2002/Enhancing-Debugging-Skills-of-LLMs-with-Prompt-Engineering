import java.util.Arrays;

class Solution {
    public boolean checkIfExist(int[] arr) {
        int l, mid = 0, r;
        int val1, val2;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            l = 0;
            r = arr.length - 1;
            while (l <= r) {
                mid = (l + r) / 2;
                val1 = arr[mid];
                val2 = arr[i] * 2;
                if (val1 == val2 && mid != i)
                    return true;
                else if (val2 < val1)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return false;
    }

    private void sort(int[] arr) {
        Arrays.sort(arr);
    }
}