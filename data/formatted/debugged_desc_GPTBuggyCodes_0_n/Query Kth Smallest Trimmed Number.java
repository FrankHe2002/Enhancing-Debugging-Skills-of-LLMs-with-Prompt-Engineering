```java
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        if (nums.length == 0)
            return new int[0];

        int[] result = new int[queries.length];
        int strLen = nums[0].length();

        for (int i = 0; i < queries.length; i++) {
            int trimi = queries[i][1];
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
                String trimmedA = nums[a].substring(strLen - trimi);
                String trimmedB = nums[b].substring(strLen - trimi);
                if (trimmedA.equals(trimmedB))
                    return a - b;
                return trimmedA.compareTo(trimmedB);
            });

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