```java
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int prev = arr[n - 1];
        int i = n - 2;
        while (i >= 0 && arr[i] <= prev) {
            prev = arr[i];
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
```