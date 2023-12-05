```java
class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        int[] ans = new int[2];
        Arrays.sort(stones);
        int minMoves = Integer.MAX_VALUE;
        int maxMoves = 0;
        
        for (int i = 0, j = 0; j < n; j++) {
            while (stones[j] - stones[i] + 1 > n) {
                i++;
            }
            
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - (j - i + 1));
            }
            
            maxMoves = Math.max(maxMoves, j - i + 1 - n + 1);
        }
        
        ans[0] = minMoves;
        ans[1] = maxMoves;
        
        return ans;
    }
}
```