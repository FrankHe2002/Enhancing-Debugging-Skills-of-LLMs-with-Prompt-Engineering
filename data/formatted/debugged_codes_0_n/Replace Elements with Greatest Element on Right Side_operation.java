class Solution {
    public int[] replaceElements(int[] arr) {
        int greatElement = - 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = greatElement;
            greatElement = Math.max(temp, greatElement);
        }
        arr[arr.length - 1] = - 1;
        return arr;
    }
}