```java
// Runtime: 11 ms (Top 83.93%) | Memory: 43.9 MB (Top 71.73%)
class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {

            int size = lis.size();

            if (size == 0 || num > lis.get(size - 1)) {
                lis.add(num);
            } else {
                int insertIndex = bs(lis, num);
                lis.set(insertIndex, num);
            }
        }

        return lis.size();
    }

    int bs(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
```