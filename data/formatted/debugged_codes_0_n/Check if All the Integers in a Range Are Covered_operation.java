class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean flag = false;
        for (int i = left; i <= right; i++) {
            flag = false;
            for (int[] arr : ranges) {
                if (i >= arr[0] && i <= arr[1]) {
                    flag = true;
                    break;
                }
            }
            if (! flag) {
                return false;
            }
        }

        return true;
    }
}