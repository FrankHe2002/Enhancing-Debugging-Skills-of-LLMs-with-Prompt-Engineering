Fixed Code:
```java
// Runtime: 1 ms (Top 100%) | Memory: 103.7 MB (Top 20.61%)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int r = nums2.length - 1;
            int l = i;
            int m = i;
            while (l <= r) {
                m = l + (r - l) / 2;
                if (nums1[i] > nums2[m + 1]) {
                    r = m - 1;
                } else if (nums1[i] == nums2[m]) {
                    l = m + 1;
                } else {
                    l = m + 1;
                }
            }
            if (r < i) {
                continue;
            }
            max = Math.max(max, r - i);
        }
        return max;
    }
}
```