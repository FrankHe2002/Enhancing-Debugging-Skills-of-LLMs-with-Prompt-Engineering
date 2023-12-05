```java
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int lo = 1;
        int hi = (int) 1e5;

        int ans = - 1;

        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            if (isItPossible(mid, quantities, n)) {
                ans = mid;
                hi = mid - 1; // fixed to narrow down the upper boundary for better efficiency
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    private boolean isItPossible(int x, int[] quantities, int n) {
        //  fixed quantity of products to be distributed to each of the n shops
        for (int i = 0; i < quantities.length; i++) {
            int products = quantities[i];
            n -= (products + x - 1) / x;
            if (n < 0)     // means it requires more than n shops to distribute all products
                return false;
        }

        return true; // distributed all products to exactly n shops
    }
}
```