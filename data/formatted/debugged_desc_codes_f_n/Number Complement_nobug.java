```java
class Solution {
    public int findComplement(int num) {
        int res = 0;
        int pos = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                res += (1 << pos);
            }
            pos++;
            num >>= 1;
        }
        return res;
    }
}
```