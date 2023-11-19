Bug Type: Array Index Out of Bounds Exception, Syntax Error

Reasoning:
1) In the `for` loop condition of the `cutOffTree` method, `forest.get(i).get(j)` is used to check if a tree exists at position `(i, j)`. However, `forest.get(i).get(j)` is comparing the tree height instead of checking if a tree exists at the position.

2) In the `calcDis` method, there are incorrect indices used when checking `vis[r + 1][c + 2]`, `vis[r - 1][c]`, `vis[r][c - 1]`, and `vis[r][c + 1]`. The indices should be `vis[r + 1][c]`, `vis[r - 1][c]`, `vis[r][c - 1]`, and `vis[r][c + 1]`, respectively.

3) There is a syntax error in the line `result += c` of the `repeatChar` method. A semicolon (`;`) is missing at the end of the statement.

Fix:
```java
class Solution {
    //approach: 1st store all the positions in min heap acc. to their height
    //now start removing the elements from heap and calculate their dis using bfs
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
            if (dis == -1)
                return -1;
            ans += dis;
            curr = temp;
        }
        return ans