class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i> grid.length-1 || j> grid[0].length-1 || grid[i][j] != 0) return true;

        grid[i][j] = 1; // to mark as visited

        boolean isClosed = true;

        if(i == 0 || j == 0 || i == grid.length -1 || j == grid[0].length - 1) isClosed = false;

        boolean top = dfs(grid, i-1, j);
        boolean bottom = dfs(grid, i+1, j);
        boolean left = dfs(grid, i, j-1);
        boolean right = dfs(grid, i, j+1);

        return isClosed && top && bottom && left && right;
    }
}