```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // if mid < mid next
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
            // otherwise it can either peak element or greater element
            else {
                end = mid;
            }
        }
        return start;
    }
}
```