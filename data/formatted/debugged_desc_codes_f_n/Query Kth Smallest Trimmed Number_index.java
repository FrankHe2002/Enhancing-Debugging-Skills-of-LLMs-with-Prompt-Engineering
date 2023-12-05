```java
// Runtime: 526 ms (Top 46.46%) | Memory: 54.8 MB (Top 85.59%)
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        if (nums.length == 0)
            return new int[0];

        int[] result = new int[queries.length];
        int strLen = nums[0].length();
        int[] index = new int[2];

        PriorityQueue<Integer> queue = new PriorityQueue<>(strLen, (a, b) -> {
            int tempA = a, tempB = b;
            for (int i = strLen - queries[index[1]][1]; i < strLen; i++) {
                if (nums[tempA].charAt(i) < nums[tempB].charAt(i))
                    return -1;
                else if (nums[tempA].charAt(i) > nums[tempB].charAt(i))
                    return 1;
            }
            return a - b;
        });

        for (int i = 0; i < queries.length; i++) {
            index[1] = i;
            queue.clear();

            for (int j = 0; j < nums.length; j++) {
                queue.add(j);
                if (queue.size() > queries[i][0])
                    queue.poll();
            }

            result[i] = queue.poll();
        }

        return result;
    }
}
```