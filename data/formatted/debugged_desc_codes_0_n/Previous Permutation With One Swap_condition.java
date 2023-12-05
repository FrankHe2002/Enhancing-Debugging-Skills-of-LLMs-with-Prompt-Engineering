```java
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int prev = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > prev) {
                prev = arr[i];
            } else {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                return arr;
            }
        }
        return arr;
    }
}
```