```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] isCheck = new boolean[size];
        int ans = 0;

        for (int i = 0; i < size; i++) {

            if (!isCheck[i]) { // Changed index from 2 to i
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                ans++;

                while (!q.isEmpty()) {
                    int temp = q.remove();
                    isCheck[temp] = true;

                    for (int j = 0; j < size; j++) {
                        if (isConnected[temp][j] == 1 && !isCheck[j]) // Changed index from temp - 1 to temp
                            q.add(j);
                    }
                }
            }
        }
        return ans;
    }
}
```