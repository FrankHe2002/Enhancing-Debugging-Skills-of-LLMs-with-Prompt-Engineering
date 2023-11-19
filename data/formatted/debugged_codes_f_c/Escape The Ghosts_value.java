Bug type: Incorrect array index

Reasoning: In the loop condition `Math.abs(ghost[0] - target[0]) + Math.abs(ghost[2] - target[1]) <= dist`, the indices `0` and `2` are used to access elements of the `ghost` array. However, the `ghost` array is a 2D array, so the indices should be `0` and `1` to access the x and y coordinates respectively.

Fix:
```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.8 MB (Top 88.81%)
// Escape The Ghosts
// Leetcode: https://leetcode.com/problems/escape-the-ghosts/

class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= dist) {
                return false;
            }
        }
        return true;
    }
}
```