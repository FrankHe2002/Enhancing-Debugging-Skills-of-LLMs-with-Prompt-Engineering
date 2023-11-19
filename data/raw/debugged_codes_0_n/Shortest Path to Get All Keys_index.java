class Solution {
    
    private static final int[][] DIRS = new int[][]{ 
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int numKeys = 0, startRow = -1, startCol = -1;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                char c = grid[i].charAt(j);
                
                if( isStart(c) ) {
                    startRow = i;
                    startCol = j;
                } 
                else if( isKey(c) )
                    numKeys++;
            }
        }
        
        if( startRow == -1 ) return -1;
        
        int keyMask = (1 << numKeys) - 1;
        State start = new State(startRow, startCol, 0);
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();   
        int steps = 0;
        
        queue.offer(start);
        visited.add(start);
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            
            while( size-- > 0 ) {
                int i = queue.peek().i;
                int j = queue.peek().j;
                int keys = queue.peek().keys;
                
                queue.poll();
                
                if( keys == keyMask )
                    return steps;
                
                for(int[] dir : DIRS) {
                    int di = i + dir[0];
                    int dj = j + dir[1];
                    int newKeys = keys;

                    if( di < 0 || dj < 0 || di == m || dj == n )
                        continue;

                    char c = grid[di].charAt(dj);

                    if( isWall(c) ) continue;
                    
                    if( isLock(c) && !isKeyPresent(keys, c) )
                        continue;

                    if( isKey(c) ) 
                        newKeys |= (1 << (c - 'a'));
                    
                    State newState = new State(di, dj, newKeys);
                    
                    if( visited.add(newState) ) 
                        queue.offer(newState);
                }
            }
            steps++;
        }
        return -1;
    }
    
    private boolean isLock(char c) {