```java
// Runtime: 11 ms (Top 68.46%) | Memory: 54.3 MB (Top 56.38%)

class Solution {
    public int maxSumDivThree(int[] nums) {
        int r0 = 0;
        int r1 = Integer.MIN_VALUE;
        int r2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int a = r0 + nums[i];
            int b = r1 + nums[i];
            int c = r2 + nums[i];
            if (a % 3 == 0) {
                r0 = Math.max(a, r0);
            } 
            if (a % 3 == 1) {
                r1 = Math.max(a, r1);
            } 
            if (a % 3 == 2) {
                r2 = Math.max(a, r2);
            }

            if (b % 3 == 0) {
                r0 = Math.max(b, r0);
            } 
            if (b % 3 == 1) {
                r1 = Math.max(b, r1);
            } 
            if (b % 3 == 2) {
                r2 = Math.max(b, r2);
            }

            if (c % 3 == 0) {
                r0 = Math.max(c, r0);
            } 
            if (c % 3 == 1) {
                r1 = Math.max(c, r1);
            } 
            if (c % 3 == 2) {
                r2 = Math.max(c, r2);
            }
        }

        return r0;
    }
}
```