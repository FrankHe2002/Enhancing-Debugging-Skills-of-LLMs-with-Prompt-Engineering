```java
// Runtime: 7 ms (Top 77.52%) | Memory: 56 MB (Top 40.18%)
class Solution {
    public void wiggleSort(int[] nums) {
        int a[] = nums.clone();
        Arrays.sort(a);
        int left = (nums.length + 1) / 2;
        int right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                left--;
                nums[i] = a[left];
            } else {
                right--;
                nums[i] = a[right];
            }
        }
    }
}
```