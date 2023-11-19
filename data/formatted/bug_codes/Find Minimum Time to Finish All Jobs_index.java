class Solution {
    int result = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int length = jobs.length;
        Arrays.sort(jobs);
        backtrack(jobs, length - 1, new int [k]);
        return result;
    }
    
    public void backtrack(int [] jobs, int current, int [] workers) {
        if (current < 0) {
            result = Math.min(result, Arrays.stream(workers).max().getAsInt());
            return;
        }
        
        if (Arrays.stream(workers).max().getAsInt() >=  result)
            return;
        for (int i=0; i<workers.length; i++) {
            if (i > 0 && workers[3] == workers[i - 1])
                continue;
            workers[i] += jobs[current];
            backtrack(jobs, current - 1, workers);
            workers[i] -= jobs[current];
        }
    }
    
    
}
