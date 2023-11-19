```java
class Solution {
    boolean flag = false;

    public boolean canCross(int[] stones) {
        int i = 0;
        int k = 1;
        flag = false;
        return canBeCrossed(stones, k, i);
    }

    public boolean canBeCrossed(int[] stones, int k, int i) {
        if (!flag) {
            if (i + 1 == stones.length - 1) {
                flag = true;
                return true;
            }
            if ((i + 1 >= stones.length) || (stones[i] + k < stones[i + 1])) return false;
            int temp = i + 1;
            while (temp < stones.length && stones[i] + k >= stones[temp]) temp++;
            if (temp < stones.length && stones[i] + k == stones[temp])
                return (canBeCrossed(stones, k + 1, temp) || canBeCrossed(stones, k, temp) || canBeCrossed(stones, k - 1, temp));
            else return false;
        } else return true;
    }
}
```