class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        return dfs(m, n, 0, introvertsCount, extrovertsCount, 0, 0, new Integer[m+1][introvertsCount+1][extrovertsCount+1][(1 << (n+1))][(1 << (n+1))]);
    }
    
    public int dfs(int m, int n, int row, int in_count, int ex_count, int prev_in_pos, int prev_ex_pos, Integer[][][][][] dp) {
        if(dp[row][in_count][ex_count][prev_in_pos][prev_ex_pos] != null)
            return dp[row][in_count][ex_count][prev_in_pos][prev_ex_pos];
        if((in_count == 0 && ex_count == 0) || (row == m)) 
            return 0;
        List<int[]> possible_permutations = new ArrayList<int[]>(); 
        int[] aux = new int[n];
        getPermutations(in_count, ex_count, aux, 0, possible_permutations, n);
        
        int ans = 0;
        for(int[] possible : possible_permutations) {
            int curr_in_count = in_count, curr_ex_count = ex_count;
            int curr_in_pos = 0, curr_ex_pos = 0;
            for(int i = 0; i < n; i++) {
                if(possible[i] == 0)
                    continue;
                if(possible[i] == -1) {
                    curr_in_count--;
                    curr_in_pos |= (1 << i);
                }
                else {
                    curr_ex_count--;
                    curr_ex_pos |= (1 << i);
                }
            }
            int curr_row_val = calculate(possible, prev_in_pos, prev_ex_pos, n);            
            int rest_rows_val = dfs(m, n, row+1, curr_in_count, curr_ex_count, curr_in_pos, curr_ex_pos, dp);
            ans = Math.max(ans, curr_row_val + rest_rows_val);
        }
        return dp[row][in_count][ex_count][prev_in_pos][prev_ex_pos] = ans;
    }
    
    public int calculate(int[] currRow, int prev_in_pos, int prev_ex_pos, int columns) {
         int res = 0;