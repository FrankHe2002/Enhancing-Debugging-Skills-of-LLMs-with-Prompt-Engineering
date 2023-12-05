```java
// Runtime: 724 ms (Top 51.43%) | Memory: 118.9 MB (Top 56.19%)
class Solution {
    static final int limit = 1000000;//boundary check

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();//HashSet to reduce the access time from O(N)-> O(1)

        for (int block[] : blocked)
            blocks.add(block[0] + "-" + block[1]);//putting the blocked node into the HashSet to access it at O(1)

        return bfsRange(source, target, blocks) && bfsRange(target, source, blocks);//sector division
    }

    public boolean bfsRange(int[] source, int[] target, Set<String> blocks) {//we simply do bsf to check the circular quadrant 1/4th boundary of the sector

        Set<String> visited = new HashSet<>();//visited hash set is so that we dont visit the visited cell again and the access time is O(1)
        Queue<int[]> q = new LinkedList<>();//as we use in BT

        q.offer(source);//adding the starting BFS node to the Queue
        visited.add(source[0] + "-" + source[1]);//marking it as visited so that we dont traverse it again

        int count = 0;//number of node traverse total outside + inside
        while (!q.isEmpty()) {//r mw a*
            int temp[] = q.poll();//poling the node
            count += 1;//counting the number of node traverse

            int trav[][] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};//Traversing in 4-Direction

            for (int direction[] : trav) {
                int i = temp[0] + direction[0];
                int j = temp[1] + direction[1];

                String key = (i + "-" + j);

                if (i < 0 || j < 0 || i >= limit || j >= limit || visited.contains(key) || blocks.contains(key))
                    continue;//base case

                if (i == target[0] && j == target[1])
                    return true;//best case saves a lot of time

                visited.add(key);//marking the node as visited and adding it to the Queue

                q.offer(new int[]{i, j});//Expaning the search for path and adding the node

                if (count > 19900)
                    return true;//path exists from this node
            }
        }
        return false;//no path, to reach the node//boundary blocked us
    }
}//Please do Upvote, it helps a lot
```