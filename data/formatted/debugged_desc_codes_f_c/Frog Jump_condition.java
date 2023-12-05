```java
class Solution {
    static boolean flag = false;   // If flag is true no more operations in recursion, directly return statement

    public boolean canCross(int[] stones) {
        int i = 0; // starting stone
        int k = 1; // starting jump
        flag = false;
        return canBeCrossed(stones, k, i);
    }

    public boolean canBeCrossed(int[] stones, int k, int i) {
        if (! flag) { // If flag is false
            if (i == stones.length - 1) { // If frog has reached the last stone, return true
                flag = true;
                return true;
            }
            // The updated condition checks if the current stone has a valid jump to the next stone
            if (stones[i] + k > stones[i] && stones[i] + k <= stones[stones.length - 1]) {
                for (int j = i + 1; j < stones.length; j++) {
                    int gap = stones[j] - stones[i];
                    if (gap >= k - 1 && gap <= k + 1) {
                        if (canBeCrossed(stones, gap, j)) {
                            return true;
                        }
                    } else if (gap > k + 1) {
                        break; // If the gap between stones is greater than k + 1, the loop can be exited
                    }
                }
            }
            return false;
        } else return true;
    }
}
```