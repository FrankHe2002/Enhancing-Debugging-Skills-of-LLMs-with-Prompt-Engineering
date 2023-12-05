```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1; // The start of the range should be 1 instead of 0
        int e = n;

        while (s < e) {
            int mid = s + (e - s) / 2; // The division should be by 2 instead of 1

            if (isBadVersion(mid)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return e;
    }
}
```