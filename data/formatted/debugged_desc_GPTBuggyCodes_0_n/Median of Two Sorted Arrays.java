```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0.0;
        int i = 0;
        int j = 0;
        int k = 0;
        int nums[] = new int[nums1.length + nums2.length];
        if (nums1.length != 0 && nums2.length != 0) {
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums[k] = nums1[i];
                    i++;
                } else {
                    nums[k] = nums2[j];
                    j++;
                }
                k++;
            }
            while (i < nums1.length) {
                nums[k] = nums1[i];
                i++;
                k++;
            }
            while (j < nums2.length) {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        int mid = (nums.length / 2);
        if (nums.length % 2 == 0) {
            return ((double) (nums[mid] + nums[mid - 1]) / 2.0);
        } else {
            return (double) nums[mid];
        }
    }
}
```