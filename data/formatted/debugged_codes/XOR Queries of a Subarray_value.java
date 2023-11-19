class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor[i] = arr[i] ^ xor[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] != 0) {
                ans[i] = xor[queries[i][1]];
                for (int j = 0; j < queries[i][0]; j++) {
                    ans[i] = arr[j] ^ ans[i];
                }
            } else
                ans[i] = xor[queries[i][1]];
        }
        return ans;
    }
}