```java
class Solution {
    public int sum(int num1, int num2) {
        int l = - 200, r = 200;
        while (l < r) {
            int mid = (l + r) >> 1;
            int sum = num1 + num2;
            if (mid == sum) {
                return mid;
            }
            if (mid < sum) l = mid + 1;
            if (mid > sum) r = mid - 1;
        }
        return l;
    }
}
```