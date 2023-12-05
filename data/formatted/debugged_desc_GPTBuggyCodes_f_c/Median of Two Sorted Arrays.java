The bug in the code is that it consistently returns the median of the concatenated array nums1 and nums2 without properly combining and sorting the two arrays. We will fix this by sorting the combined array and then returning the median as required.

The fixed code for the provided buggy Java code is as follows:

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] sortedArr = new int[m + n];
        int i = 0, j = 0, k = 0;
        
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                sortedArr[k] = nums1[i];
                i++;
            } else {
                sortedArr[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while (i < m) {
            sortedArr[k] = nums1[i];
            i++;
            k++;
        }
        
        while (j < n) {
            sortedArr[k] = nums2[j];
            j++;
            k++;
        }
        
        if ((m + n) % 2 == 0) {
            return (double) (sortedArr[(m + n) / 2] + sortedArr[(m + n) / 2 - 1]) / 2;
        } else {
            return (double) sortedArr[(m + n) / 2];
        }
    }
}
```