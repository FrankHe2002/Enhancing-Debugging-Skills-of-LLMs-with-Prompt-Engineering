```java
// Runtime: 2 ms (Top 64.18%) | Memory: 40.9 MB (Top 74.82%)
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0){
            return false;
        }
        while(n != 1){
            if(n % 4 != 0){
                return false;
            }
            n = n / 4;
        }
        return true;
    }
}
```