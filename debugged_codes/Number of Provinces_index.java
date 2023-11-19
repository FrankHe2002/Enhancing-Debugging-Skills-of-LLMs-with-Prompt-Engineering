class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] isCheck = new boolean[size];
        int ans = 0;

        for(int i=0; i<size; i++){

            if(!isCheck[i]){ // Doing BFS if it's false in isCheck[]
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                ans++; // No. of queue = No. of Graphs

                while(!q.isEmpty()){
                    int temp = q.remove();
                    isCheck[temp] = true;

                    for(int j=0; j<size; j++){
                        if(isConnected[temp][j]==1 && !isCheck[j])
                            q.add(j);
                    }
                }
            }
        }
        return ans;
    }
}