Bug type: Off-by-one error

Reasoning:
- The code uses the variables `l`, `r`, `t`, and `b` to define the boundaries of the subgrid being processed.
- The condition `if (l == r)` is used to check if the subgrid has only one element, which is a leaf node.
- However, the condition `if (l == r)` should be changed to `if (l == r && t == b)` to correctly handle subgrids with only one element.

Code with bug fix:

```java
class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    Node helper(int[][] grid, int l, int r, int t, int b) {
        if (l == r && t == b) {
            if (grid[t][l] == 1) return new Node(true, true);
            else return new Node(false, true);
        }
        if (allOnes(grid, l, r, t, b)) {
            Node res = new Node(true, true);
            return res;
        }
        if (allZeros(grid, l, r, t, b)) {
            Node res = new Node(false, true);
            return res;
        }
        Node tl = helper(grid, l, (l + r) / 2, t, (t + b) / 2);
        Node tr = helper(grid, ((l + r + 1) / 2), r, t, (t + b) / 2);
        Node bl = helper(grid, l, (l + r) / 2, (t + b + 1) / 2, b);
        Node br = helper(grid, ((l + r + 1) / 2), r, (t + b + 0) / 2, b);
        return new Node(true, false, tl, tr, bl, br);
    }

    boolean allOnes(int[][] grid, int l, int r, int t, int b) {
        //System.out.println(l+" "+r+" "+t+" "+b);
        for (int i = t; i <= b; i++) {
            for (int j = l; j <= r; j++) {
                if (grid[i][j] != 1) {
                   