The bug in the code is in the second for loop that goes from 1 to n/2 (inclusive) Instead it should go from -1 to -n/2  j++ keeps track of the position where the number of the array is placed so to place the negative values at the right position we will need to increment j as well. 

The code can be fixed by reversing the second for loop to iterate from -1 to -n/2, and also increment j within the loop.

Here's the fixed code:

```java
class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int j = 0;

        for (int i = 1; i <= n / 2; i++) {
            ans[j] = i;
            j++;
        }
        for (int i = 1; i <= n / 2; i++) {
            ans[j] = -i;
            j++;
        }
        if (n % 2 != 0) ans[j] = 0;

        return ans;
    }
}
```