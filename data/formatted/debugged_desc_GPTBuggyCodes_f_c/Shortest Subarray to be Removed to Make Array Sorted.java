```java
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int firstLast = 0, lastFirst = arr.length - 1;
        for (; firstLast < arr.length - 1; firstLast++) {
            if (arr[firstLast] > arr[firstLast + 1]) break;
        }
        if (firstLast == arr.length - 1) return 0;
        for (; lastFirst > 0; lastFirst--) {
            if (arr[lastFirst] < arr[lastFirst - 1]) break;
        }
        int minLength = Math.min(arr.length - firstLast - 1, lastFirst);
        for (; firstLast >= 0; firstLast--) {
            for (int i = lastFirst; i < arr.length; i++) {
                if (i < arr.length - 1 && arr[firstLast] > arr[i + 1]) {
                    minLength = Math.min(minLength, i - firstLast);
                    break;
                }
            }
        }
        return minLength;
    }
}
```