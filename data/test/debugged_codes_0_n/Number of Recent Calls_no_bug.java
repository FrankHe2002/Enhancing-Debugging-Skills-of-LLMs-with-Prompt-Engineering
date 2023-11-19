// Runtime: 29 ms (Top 97.21%) | Memory: 52.6 MB (Top 11.35%)

class RecentCounter {
    ArrayList<Integer> calls ;
    public RecentCounter() {
        calls = new ArrayList<Integer>();
    }
    
    public int ping(int t) {
        calls.add(t);
        int count = 0;
        for(Integer call:calls){
            if( t-call<=3000) count++;
        }
        while (calls.get(0) < t - 3000) {
            calls.remove(0);
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */