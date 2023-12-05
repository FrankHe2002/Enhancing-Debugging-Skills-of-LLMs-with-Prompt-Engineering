```java
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        if (nums.length == 0)
            return new int[0];

        int[] result = new int[queries.length];
        int[] original = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            original[i] = Integer.parseInt(nums[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            String[] trimmed = new String[nums.length];
            for (int j = 0; j < nums.length; j++) {
                trimmed[j] = nums[j].substring(nums[j].length() - queries[i][1]);
                nums[j] = "" + original[j];
            }
            Arrays.sort(trimmed);
            result[i] = Integer.parseInt(trimmed[queries[i][0] - 1]);
        }

        return result;
    }
}
```