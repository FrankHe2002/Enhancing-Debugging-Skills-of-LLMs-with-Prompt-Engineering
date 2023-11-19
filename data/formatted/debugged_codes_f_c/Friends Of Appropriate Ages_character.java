Bug type: Syntax Error

Reasoning: The buggy code has a missing closing parenthesis ")" at the end of the line `ans += Math.max(0, t - k - 1;`. The semicolon ";" should be closed with a closing parenthesis ")". This is a syntax error and will cause a compile-time error.

Fixed code:
```java
class Solution {
    static int upperBound(int arr[], int target) {
        int l = 0, h = arr.length - 1;
        for (; l <= h; ) {
            int mid = (l + h) >> 1;
            if (arr[mid] <= target)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return l;
    }

    public int numFriendRequests(int[] ages) {
        long ans = 0;
        Arrays.sort(ages);
        // traversing order doesn't matter as we are doing binary-search in whole array
        // you can traverse from left side also
        for (int i = ages.length - 1; i >= 0; --i) {
            int k = upperBound(ages, ages[i] / 2 + 7);
            int t = upperBound(ages, ages[i]);
            ans += Math.max(0, t - k - 1);
        }
        return (int) ans;
    }
}
```