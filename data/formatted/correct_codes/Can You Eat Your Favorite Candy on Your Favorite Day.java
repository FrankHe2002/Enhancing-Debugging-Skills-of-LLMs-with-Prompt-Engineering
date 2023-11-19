class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] prefix = new long[candiesCount.length + 1];
        boolean[] res = new boolean[queries.length];
        prefix[0] = 0;

        for (int i = 1; i < prefix.length; i++)
            prefix[i] = prefix[i - 1] + candiesCount[i - 1];

        for (int i = 0; i < res.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long maxDay = prefix[type + 1] - 1;
            long minDay = prefix[type] / cap;
            res[i] = (minDay <= day && day <= maxDay);
        }

        return res;
    }
}
