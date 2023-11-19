```java
class Solution {

    //mod 
    long mod = (long) (Math.pow(10, 11) + 3);

    long p = 100003;

    long p_i[];

    public int longestCommonSubpath(int n, int[][] paths) {

        //min length will be 2 
        int min = 1;

        //max length will be the (path of min length) 

        int max = Integer.MAX_VALUE;

        for (int path[] : paths) {
            max = Math.min(max, path.length);
        }

        //now we will pre calculate the the powers of base
        //and upto max only bcoz that's the longest subarray 
        //we are going to deal with
        p_i = new long[max + 1];

        p_i[0] = 1;

        for (int i = 1; i <= max; i++) {
            //mod multiplication
            p_i[i] = mulmod(p_i[i - 1], p, mod);
        }

        int ans = 0;

        while (min <= max) {

            int mid = (min + max) / 2;

            if (solve(mid, paths)) {
                //if this length satisfies 
                //we are moving to right  
                //checking length greater than this
                ans = mid;
                min = mid + 1;
            } else {
                //else smaller
                max = mid - 1;
            }

        }

        return ans;

    }

    public boolean solve(int len, int paths[][]) {

        Map<Long, Long> map = new HashMap<>();

        // now for each path we are going to calculate the 
        // hash value for each subpath of length -> len
        // and store the frequency of hash in map
        // and if for a hash value the frequency equals 
        // paths.length it means it exists in all path array
        // so return true

        for (int path[] : paths) {

            long hash = 0l;

            // we are using a set for storing hash value of particular len for 
            // each path beacuse there is a possibility 
            // that a subpath repeats multiple times 
            // in a path so it directly updating in map
            // will lead to wrong count
            Set<Long> set = new HashSet<>();

            // hash is calculated as
            // let's say len is 3
