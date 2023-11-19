Bug Type: ArrayIndexOutOfBoundsException

Reasoning: The bug occurs in the following line of code:
```
for (int i = 1; i <= nums.length; i++) {
```
The loop condition `i <= nums.length` attempts to access an index out of the array's bounds. In Java, array indices range from 0 to `length - 1`. Therefore, the loop condition should be `i < nums.length` to ensure the loop iterates only within the array's valid range.

Fix:
```java
for (int i = 1; i < nums.length; i++) {
```

Fixed Code:
```java
// Runtime: 273 ms (Top 92.8%) | Memory: 44.58 MB (Top 18.0%)

class Solution {
    //approach: 1st store all the positions in the min heap acc. to their height
    //now start removing the elements from the heap and calculate their dis using bfs
    // if at any point we cann't reach at the next position return -1;
    // else keep on adding the distances and return;
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1])));
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1)
                    pq.add(new int[] {i, j});
            }
        }
        int ans = 0;
        int curr[] = {0, 0};
        while (pq.size() > 0) {
            int[] temp = pq.poll();
            int dis = calcDis(forest, curr, temp);
            //System.out.println(dis+" "+temp.height);
            if (dis == - 1)
                return - 1;
            ans += dis;
            curr = temp;
        }
        return ans;
    }

    int calcDis(List<List<Integer>> forest, int start[], int end[]) {
        int n = forest.size(), m = forest.get(0).size();
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        vis[start[0]][start[1