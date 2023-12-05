```java
// Runtime: 152 ms (Top 66.6%) | Memory: 154.57 MB (Top 22.2%)

class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] count = new int[n + 1][101];  // change array size to 101
        int q = queries.length;
        int ans[] = new int[q];  // change array size to q

        for (int i = 0; i < n; ++ i) {
            for (int j = 0; j < 100; ++ j)  // change limit to 100
                count[i + 1][j] = count[i][j];

            int numIndex = nums[i];
            ++ count[i + 1][numIndex];  // decrement the number by 1 to fit the index properly
        }

        for (int i = 0; i < q; ++ i) {
            int low = queries[i][0];
            int high = queries[i][1] + 1;
            List<Integer> present = new ArrayList<>();
            int min = n; // change to maximum possible value to effectively find minimum difference

            for (int j = 0; j < 100; ++ j)
                if (count[high][j] - count[low][j] != 0)
                    present.add(j);

            for (int j = 1; j < present.size(); ++ j)
                min = Math.min(min, present.get(j) - present.get(j - 1));

            if (present.isEmpty())
                min = - 1;

            ans[i] = min;
        }

        return ans;
    }
}
```