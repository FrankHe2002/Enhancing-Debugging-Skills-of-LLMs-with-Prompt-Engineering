The code is incorrect. Fix by ensuring that a<=b<=c, and then return a + b if c >= a + b. Otherwise, return (a + b + c) / 2.

Fix:
```java
class Solution {
    public int maximumScore(int a, int b, int c) {
        // Make sure a <= b <= c
        if (a > b) return maximumScore(b, a, c);
        if (b > c) return maximumScore(a, c, b);

        // if a+b is less than or equal to c, we can definitely combine all piles
        if (a + b <= c) return a + b;

        // a+b is greater than c, then we can combine all piles after making the largest pile empty
        return (a + b + c) / 2;
    }
}
```