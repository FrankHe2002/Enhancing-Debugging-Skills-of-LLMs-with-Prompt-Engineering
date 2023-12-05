```java
class Solution {
    public int maximumScore(int a, int b, int c) {
        // Make sure a <= b <= c
        if (a > b) return maximumScore(b, a, c);
        if (b > c) return maximumScore(a, c, b);

        // if sum of smallest numbers [a+b] is less than c, then we can make a + b pairs with the c
        if (a + b <= c) return a + b;

        // if sum of smallest numbers is greater than c, then we can make (a+b+c)/2 pairs after making c empty
        return (a + b + c) / 2;
    }
}
```