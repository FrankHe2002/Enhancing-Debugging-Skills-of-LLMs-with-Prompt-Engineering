```java
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int i = - 1, lisSize = - 1;
        int[] lis = new int[obstacles.length];
        int[] ans = new int[obstacles.length];

        for (int curHeight : obstacles) {
            int cur = search(lis, 0, i, curHeight);
            lis[cur] = curHeight;
            if (cur > i) {
                i = cur;
            }
            ans[cur] = i + 1;
        }
        return ans;
    }

    private int search(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        int boundary = end + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                boundary = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return boundary;
    }
}
```