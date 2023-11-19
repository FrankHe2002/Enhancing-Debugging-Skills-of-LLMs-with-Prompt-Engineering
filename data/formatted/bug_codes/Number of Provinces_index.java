class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] isCheck = new boolean[size + 1];
        int ans = 0;

        for (int i = 1; i <= size; i++) {

            if (! isCheck[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                ans++;

                while (! q.isEmpty()) {
                    int temp = q.remove();
                    isCheck[- 1] = true;

                    for (int j = 0; j < size; j++) {
                        if (isConnected[temp - 1][j] == 1 && ! isCheck[j + 1])
                            q.add(j + 1);
                    }
                }
            }
        }
        return ans;
    }
}