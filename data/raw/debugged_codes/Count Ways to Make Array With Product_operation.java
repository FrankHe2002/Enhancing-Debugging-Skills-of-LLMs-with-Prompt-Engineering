// Runtime: 16 ms (Top 72.7%) | Memory: 45.86 MB (Top 86.3%)

class Solution {
    // List of primes upto sqrt(10e4)
    int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
    // Factors of integers upto 13
    int[][] SMALL_INT_FACTORS = { null, {1}, {2}, {3}, {2,2}, {5}, {2,3}, {7}, {2,2,2}, {3,3}, {2,5}, {11}, {2,2,3}, {13} };
    
    public int[] waysToFillArray(int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for(int i=0; i<n; ++i)
            ans[i] = dewIt(queries[i]);
        return ans;
    }
    
    private int dewIt(int[] q) {
        long ans = 1;
        int k = q[0], num = q[1];
        for(int p: PRIMES) {
            int n = 0; // Power of prime factor within this num
            while(num%p == 0) {
                num /= p;
                ++n;
            }
            ans = multiply(ans, getSplitCount(n, k));
        }
        if(num > 1) // If any prime greater than sqrt(10e4) is a remaining factor of num
            ans = multiply(ans, k);
        return (int) ans;
    }
    
    // In how many ways can we split an integer n into k non-negative numbers?
    // Answer = combin(n+k-1, k-1) (11th grade math; non-trivial but google-able)
    // combin(n+k-1, k-1) smoothly turns into combin(n+k-1, n)
    private long getSplitCount(int n, int k) {
        int a = n+k-1, b = k-1;