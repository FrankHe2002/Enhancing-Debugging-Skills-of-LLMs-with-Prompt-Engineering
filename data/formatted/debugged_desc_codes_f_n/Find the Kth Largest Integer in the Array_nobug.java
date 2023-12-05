```java
// Runtime: 107 ms (Top 27.4%) | Memory: 53.91 MB (Top 31.3%)

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        int n = nums.length;

        Arrays.sort(nums, (a, b) -> {
            if (a.length() > b.length()) return 1;
            else if (b.length() > a.length()) return - 1;
            else {
                return a.compareTo(b);
            }
        });
        return nums[n - k];
    }
}
```