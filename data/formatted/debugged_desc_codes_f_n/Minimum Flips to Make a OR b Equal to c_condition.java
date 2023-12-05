```java
// Runtime: 0 ms (Top 100.00%) | Memory: 39.2 MB (Top 89.45%)
class Solution {
    public int minFlips(int a, int b, int c) {
        int j = 0;
        int x = a | b;
        int count = 0;
        while (c > 0 || x > 0) {
            int aa = x & 1;
            int bb = c & 1;
            if (aa == 0 && bb == 1) count++;
            else if (aa == 1 && bb == 0) count += funcount(j, a, b);
            x = x >> 1;
            c = c >> 1;
            j++;
        }
        return count;
    }

    public static int funcount(int shift, int a, int b) {
        int cc = 0;
        int mask = 1 << shift;
        int b1 = a & mask;
        int b2 = b & mask;
        if (b1 == 0 && b2 == 0) cc++;
        if ((b1 != 0 && b2 == 0) || (b1 == 0 && b2 != 0)) cc++;
        return cc;
    }
}
```