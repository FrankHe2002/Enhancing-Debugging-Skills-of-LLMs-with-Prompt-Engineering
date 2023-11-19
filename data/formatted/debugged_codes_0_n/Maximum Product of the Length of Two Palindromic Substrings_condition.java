```java
// Runtime: 37 ms (Top 83.36%) | Memory: 61.5 MB (Top 35.02%)
// using manachers algorithm

class Solution {

    public long maxProduct(String s) {
        int n = s.length();
        if (n == 2) return 1;
        int[] len = manachers(s); // get lengths of palindromes at each element

        long[] left = new long[n]; // stores the max length of palindrome to left of each index

        int max = 1;
        left[0] = max;
        for (int i = 1; i < n - 1; i++) {
            // does any palindrome end at i with length greater than max
            if (len[(i - max - 1 + i) / 2] > max) max += 2;
            left[i] = max;
        }
        max = 1;
        long[] right = new long[n]; // stores the max length of palindrome to right of each index
        right[n - 1] = max;

        for (int i = n - 2; i >= 0; i--) {
            // does any palindrome start at i with length greater than max
            if (len[(i + max + 1 + i) / 2] > max) max += 2;
            right[i] = max;
        }

        long res = 1;

        for (int i = 1; i < n; i++) {
            res = Math.max(res, left[i - 1] * right[i]);
        }
        return res;
    }

    // credit : https://hackernoon.com/manachers-algorithm-explained-longest-palindromic-substring-22cb27a5e96f
    private int[] manachers(String s) {

        int len = s.length();
        int[] P = new int[len];
        int c = 0; //stores the center of the longest palindromic substring until now
        int r = 0; //stores the right boundary of the longest palindromic substring until now
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            //get mirror index of i
            int mirror = (2 * c) - i;

            //see if the mirror of i is expanding beyond the