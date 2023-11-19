```java
class Solution {
    static final int limit = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();

        for (int block[] : blocked)
            blocks.add(block[0] + "-" + block[1]);

        return bfsRange(source, target, blocks) && bfsRange(target, source, blocks);

    }

    public boolean bfsRange(int[] source, int[] target, Set<String> blocks) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(source);

        visited.add(source[0] + "-" + source[1]);

        int count = 0;
        while (!q.isEmpty()) {
            int temp[] = q.poll();
            count += 1;

            int trav[][] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

            for (int direction[] : trav) {
                int i = temp[0] + direction[0];
                int j = temp[1] + direction[1];

                String key = (i + "-" + j);

                if (i < 0 || j < 0 || i >= limit || j >= limit || visited.contains(key) || blocks.contains(key))
                    continue;

                if (i == target[0] && j == target[1])
                    return true;

                visited.add(key);

                q.offer(new int[]{i, j});

                if (count > 19900)
                    return true;
            }
        }
        return false;
    }
}
```